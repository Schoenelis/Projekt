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

    private Random random;
    private final Player player;
    private Texture imgBlackhole;
    private final SpriteBatch sb;
    private Sprite sprite;
    float bx;
    float by;

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
            System.out.println("Bild wurde nicht geladen.");
        }

        player = new Player(bullets);
        sb = new SpriteBatch();
        bx = 300;
        by = 300;
        width = height = 200;
        attraction = 9000000000000f;
    }

    private void attraction() {

        double dx = bx - player.px;
        double dy = by - player.py;
        double r = Math.hypot(dx, dy);
        double r3 = r * r * r;
        double a = attraction * dt / r3;

        double dvx = a * dx;
        double dvy = a * dy;

        player.vx += dvx;
        player.vy += dvy;

        System.out.println("dvx: " + dvx + " dvy: " + dvy + "\nx: " + player.x + " y: " + player.x);
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
