package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;

/**
 * Erzeugt die schuesse des Players
 *
 * @author Dreissa
 */
public class BulletPlayer extends SpaceObject {

    public static  float lifeTime;
    private float lifeTimer;

    private boolean remove;

    private Texture imgBullet;
    public SpriteBatch sb;
    public static Sprite sprite;
    public static float sx;
    public static Rectangle boundingRectangle_PlayerBullet;
    public static float sy;
    public static float bpvx;
    public static float bpvy;

    public BulletPlayer(float x, float y, float radians) {

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            imgBullet = new Texture(object.getChildByName("bullet").getAttribute("bullettexture0"));
            sprite = new Sprite(imgBullet);
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
        }
        sb = new SpriteBatch();

        sx = x;
        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 350;
        bpvx = MathUtils.cos(radians) * speed;
        bpvy = MathUtils.sin(radians) * speed;

        width = height = 2;

        lifeTimer = 0;
        lifeTime = 3;
boundingRectangle_PlayerBullet = sprite.getBoundingRectangle();
    }

    
    public boolean shouldRemove() {
        return remove;
    }

    public void update(float dt) {

        x += bpvx * dt;
        y += bpvy * dt;

        lifeTimer += dt;
        if (lifeTimer > lifeTime) {
            remove = true;
        }

    }

    public void draw() {

        sb.begin();
        sprite.setTexture(imgBullet);
        sprite.setPosition(x, y);
        sprite.draw(sb);
        
        //sb.draw(imgBullet, x, y);
        sb.end();
    }

}
