package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.ArrayList;

public class Blackhole extends SpaceObject {

    public static float attraction;
    private ArrayList<BulletPlayer> bullets;

//    private Random random;
    private final Player player;
    private Texture imgBlackhole;
    private final SpriteBatch sb;
    public static Sprite sprite;
    public static float bx;
    public static float by;
    public static int height;
    public static int width;
public static Rectangle boundingRectangle_Blackhole;

    public static void setBx(float bx) {
        Blackhole.bx = bx;
    }

    public static void setBy(float by) {
        Blackhole.by = by;
    }

    public static void setAttraction(float attraction) {
        Blackhole.attraction = attraction;
    }
    
    public Blackhole() {
        bx = x;
        by = y;

        //loading the img
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            Element object = root.getChildByName("gameobjects");
            imgBlackhole = new Texture(object.getChildByName("blackhole").getAttribute("blackholetexture0"));
            sprite = new Sprite(imgBlackhole);
        } catch (IOException ex) {
            System.err.println("Bild wurde nicht geladen." + ex);
        }

        player = new Player(bullets);
        sb = new SpriteBatch();
        bx = 300;
        by = 300;
        width = height = 200;
        
//        attraction = 90000f;
    }

    private void attraction() {

        double dx = bx - Player.px;
        double dy = by - Player.py;
        double r = Math.hypot(dx, dy);
        double r3 = r * r * r;
        double a = attraction * dt / r3;

        double dvx = a * dx;
        double dvy = a * dy;
//        BulletGegner.bgvx +=dvx;
//        BulletGegner.bgvy +=dvy;
        Player.pvx += dvx;
        Player.pvy += dvy;

    }

    public void update() {
       boundingRectangle_Blackhole = Blackhole.sprite.getBoundingRectangle();
        attraction();
    }

    public void draw() {

        sb.begin();

        sprite.setTexture(imgBlackhole);
        //Set the rotation of the Sprite.

        sprite.rotate(0.02f);
        //Set the x and y positon of the Sprite.
        sprite.setPosition(bx, bx);

        sprite.draw(sb);
        //sb.draw(imgBlackhole, x, y, width, height);
        sb.end();
    }
}
