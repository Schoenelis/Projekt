package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Blackhole extends GameObj {

    private float attraction;
    private ArrayList<Bullet> bullets;

    private Random random;
    private Player player;
    private Texture imgBlackhole;

    public Blackhole() {

        //loading the img
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));  
              Element object = root.getChildByName("gameobjects");
            imgBlackhole = new Texture(object.getChildByName("blackhole").getAttribute("blackholetexture0"));
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
            JOptionPane.showMessageDialog(null, ex, "alert", JOptionPane.ERROR_MESSAGE); 
        }

        player = new Player(bullets);
//        imgBlackhole = new Texture("Game_Grafiken/blackhole.png");
        spriteBatch = new SpriteBatch();
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
    }

    public void update() {
        attraction();
    }

    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(imgBlackhole, x, y, width, height);
        spriteBatch.end();
    }
}
