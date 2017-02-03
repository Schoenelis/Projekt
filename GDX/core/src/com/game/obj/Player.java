package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Player extends GameObj {

    private ArrayList<Bullet> bullets;
    public static final int MAX_BULLETS = 4;

    private float accleration;
    private float maxSpeed;
    private int lifepoints;
    private int energy;
    private int maxEnergy;
    private float lifeTime;
    private float lifeTimer;

    private Texture imgPlayer1;

    public Player(ArrayList<Bullet> bullets) {

        //loading the Player img.
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            Element object = root.getChildByNameRecursive("gameobjects");
            imgPlayer1 = new Texture(object.getChildByName("player").getAttribute("playertexture0"));
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
            JOptionPane.showMessageDialog(null, ex, "alert", JOptionPane.ERROR_MESSAGE);
        }

        this.bullets = bullets;
        spriteBatch = new SpriteBatch();
      //  imgPlayer1 = new Texture("Game_Grafiken/Player/playergrafik0.png");
        x = 100;
        y = 100;
        width = height = 100;
        lifepoints = 3;
        accleration = 200f;
        maxSpeed = 500f;
        energy = 100;
        lifeTime = 1000;
        lifeTimer = 0;
        vx = vy = 0;
    }

    private void accelration() {
        if (Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
            vy += dt * accleration;

        }
        if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
            vy -= dt * accleration;

        }
        if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
            vx -= dt * accleration;

        }
        if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
            vx += dt * accleration;

        }

    }

    private void maxSpeed() {
        float vec = (float) Math.sqrt(vx * vx + vy * vy);
        if (vec > 0) {
            vx -= (vx / vec) * dt;
            vy -= (vy / vec) * dt;
        }
        if (vec > maxSpeed) {
            vx = (vx / vec) * maxSpeed;
            vy = (vy / vec) * maxSpeed;
        }
    }

    public void update() {
        windowCollision();
        accelration();
        maxSpeed();

        x += vx * dt;
        y += vy * dt;
    }

    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(imgPlayer1, x, y, width, height);
        spriteBatch.end();
    }
}
