package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Bullet extends SpaceObject {

    private float lifeTime;
    private float lifeTimer;

    private boolean remove;

    private Texture imgBullet;
    private SpriteBatch sb;

    public Bullet(float x, float y, float radians) {

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            imgBullet = new Texture(object.getChildByName("bullet").getAttribute("bullettexture0"));
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
            JOptionPane.showMessageDialog(null, ex, "alert", JOptionPane.ERROR_MESSAGE);
        }
        sb = new SpriteBatch();

        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 350;
        vx = MathUtils.cos(radians) * speed;
        vy = MathUtils.sin(radians) * speed;

        width = height = 2;

        lifeTimer = 0;
        lifeTime = 1;

    }

    public boolean shouldRemove() {
        return remove;
    }

    public void update(float dt) {

        x += vx * dt;
        y += vy * dt;

        lifeTimer += dt;
        if (lifeTimer > lifeTime) {
            remove = true;
        }

    }

    public void draw() {
        sb.begin();
        sb.draw(imgBullet, x, y);
        sb.end();
    }

}
