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

    private float attraction;
    private ArrayList<Bullet> bullets;

    private Random random;
    private Player player;
    private Texture imgBlackhole;
    private  SpriteBatch sb;
    private Sprite sprite2;

    public Blackhole() {

        //loading the img
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            Element object = root.getChildByName("gameobjects");
            imgBlackhole = new Texture(object.getChildByName("blackhole").getAttribute("blackholetexture0"));
            sprite2 = new Sprite(imgBlackhole);
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
        }

        player = new Player(bullets);
//        imgBlackhole = new Texture("Game_Grafiken/blackhole.png");
        sb = new SpriteBatch();
        x = 300;
        y = 300;
        width = height = 200;
        attraction = 3000f;
    }

    private void attraction() {
        double dx = x - player.x;
        double dy = y - player.y;
        double r = Math.hypot(dx, dy);
        double r3 = r * r * r;
        double a = attraction * dt / r3;

        double dvx = a * dx;
        double dvy = a * dy;

       player.vx += dvx;
       player.vy += dvy;
        System.out.println("player vx " + player.vx +"player vy " + player.vy);
    }

    public void update() {
        attraction();
    }

    public void draw() {
       
        sb.begin();
        
        sprite2.setTexture(imgBlackhole);
        //Set the rotation of the Sprite.
        
        sprite2.rotate(0.02f);
        //Set the x and y positon of the Sprite.
        
        sprite2.setPosition(x, y);
        
        sprite2.draw(sb);
        //  sb.draw(imgBlackhole, x, y, width, height);
        sb.end();
    }
}
