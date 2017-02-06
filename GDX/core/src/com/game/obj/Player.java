package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Player extends SpaceObject {

    private final int MAX_BULLETS = 4;
    private ArrayList<Bullet> bullets;

    private float[] flamex;
    private float[] flamey;

    private boolean left;
    private boolean right;
    private boolean up;

    private float maxSpeed;
    private float acceleration;
    private float deceleration;
    private float acceleratingTimer;

    private Texture imgPlayer;
    private SpriteBatch sb;

    public Player(ArrayList<Bullet> bullets) {

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            imgPlayer = new Texture(object.getChildByName("blackhole").getAttribute("blackholetexture0"));
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
            JOptionPane.showMessageDialog(null, ex, "alert", JOptionPane.ERROR_MESSAGE);
        }

        this.bullets = bullets;
        sb = new SpriteBatch();

        x = 0;
        y = 0;

        maxSpeed = 300;
        acceleration = 200;
        deceleration = 10;

        radians = 3.1415f / 2;
        rotationSpeed = 3;
    }

    public void setLeft(boolean b) {
        left = b;
    }

    public void setRight(boolean b) {
        right = b;
    }

    public void setUp(boolean b) {
        up = b;
    }

    public void shoot() {
        if (bullets.size() == MAX_BULLETS) {
            return;
        }
        bullets.add(new Bullet(x, y, radians));
    }

    public void update(float dt) {

        // turning
        if (left) {
            radians += rotationSpeed * dt;
        } else if (right) {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if (up) {
            vx += MathUtils.cos(radians) * acceleration * dt;
            vy += MathUtils.sin(radians) * acceleration * dt;
            acceleratingTimer += dt;
            if (acceleratingTimer > 0.1f) {
                acceleratingTimer = 0;
            }
        } else {
            acceleratingTimer = 0;
        }

        // deceleration
        float vec = (float) Math.sqrt(vx * vx + vy * vy);
        if (vec > 0) {
            vx -= (vx / vec) * deceleration * dt;
            vy -= (vy / vec) * deceleration * dt;
        }
        if (vec > maxSpeed) {
            vx = (vx / vec) * maxSpeed;
            vy = (vy / vec) * maxSpeed;
        }

        // set position
        x += vx * dt;
        y += vy * dt;

        // screen wrap
    }

    public void draw() {
        sb.begin();
        sb.draw(imgPlayer, x, y);
        sb.end();
    }

}
