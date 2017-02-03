package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Bullet extends GameObj {

    private float lifeTime;
    private float lifeTimer;
    private Texture img;

    private boolean remove;

    public Bullet() {
        //loading the bullet img.
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            Element object = root.getChildByName("gameobjects");
                  img = new Texture(object.getChildByName("bullet").getAttribute("bullettexture0"));
        } catch (IOException ex) {
          System.out.println("Bild wurde nicht geladen.");
            JOptionPane.showMessageDialog(null, ex, "alert", JOptionPane.ERROR_MESSAGE);
        }
        
       // img = new Texture("badlogic.jpg");
        spriteBatch = new SpriteBatch();

        this.x = x;
        this.y = y;

        float speed = 350;
        vx = 400 * speed;
        vy = 400 * speed;

        width = height = 20;

        lifeTimer = 0;
        lifeTime = 1;
    }

    public boolean isRemove() {
        return remove;
    }

    public void update() {
        x += vx * dt;
        y += vy * dt;

        windowCollision();

        lifeTimer += dt;
        if (lifeTimer > lifeTime) {
            remove = true;
        }
    }

    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(img, x, y, width, height);
        spriteBatch.end();
    }

}
