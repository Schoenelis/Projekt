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
 * Erzeugt die schuesse des Gegners
 * @author info
 */
public class BulletGegner extends SpaceObject {

    public static float lifeTime;
    private float lifeTimer;

    private boolean remove;
    public static Rectangle boundingRectangle_GegnerBullet;
    private Texture imgBulletGegner;
    public SpriteBatch sb;
    public static Sprite sprite;
    public static float sx;
    public static float sy;
    public static float bgvx;
    public static float bgvy;

    public BulletGegner(float x, float y, float radians) {

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            imgBulletGegner = new Texture(object.getChildByName("bullet").getAttribute("bullettexture1"));
            sprite = new Sprite(imgBulletGegner);
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
        }
        sb = new SpriteBatch();

        sx = x;
        sy = y;
        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 350;
        bgvx = MathUtils.cos(radians) * speed;
        bgvy = MathUtils.sin(radians) * speed;

        width = height = 2;

        lifeTimer = 0;
        lifeTime = 3;
        boundingRectangle_GegnerBullet = sprite.getBoundingRectangle();
    }

    public boolean shouldRemove() {
        return remove;
    }

    public void update(float dt) {

        x += bgvx * dt;
        y += bgvy * dt;

        lifeTimer += dt;
        if (lifeTimer > lifeTime) {
            remove = true;
        }

    }

    public void draw() {

        sb.begin();
        sprite.setTexture(imgBulletGegner);
        sprite.setPosition(x, y);
        sprite.draw(sb);

        //sb.draw(imgBulletGegner, x, y);
        sb.end();
    }

}
