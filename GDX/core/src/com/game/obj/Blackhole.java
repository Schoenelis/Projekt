package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Blackhole extends SpaceObject {

    private final float attraction;
    private ArrayList<Bullet> bullets;

//    private Random random;
    private final Player player;
    private Texture imgBlackhole;
    private final SpriteBatch sb;
    public static  Sprite sprite;
    static float bx;
    static float by;
    public static int height;
    public static int width;

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
            System.err.println("Bild wurde nicht geladen." +ex);
        }

        player = new Player(bullets);
        sb = new SpriteBatch();
        bx = 300;
        by = 300;
        width = height = 250;
        attraction = 9000f;
    }

    private void attraction() {

        double dx = bx - Player.px;
        double dy = by - Player.py;
        double r = Math.hypot(dx, dy);
        double r3 = r * r * r;
        double a = attraction * dt / r3;

        double dvx = a * dx;
        double dvy = a * dy;

        Player.pvx += dvx;
        Player.pvy += dvy;

//        
//         if (bx < Player.px + Player.width && by < Player.py + Player.height && bx + width > Player.px && by + height > Player.py) {
//            System.out.println("tot");
//            Player.px= 512;
//            Player.py = 50;
//        }
       // System.out.println("dvx: " + dvx + " dvy: " + dvy + "\nx: " + Player.px + " y: " + Player.px);
       
    }

    public void update() {
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
