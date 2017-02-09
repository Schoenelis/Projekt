package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;

public class Player extends SpaceObject {

    private final int MAX_BULLETS = 4;
    private ArrayList<Bullet> bullets;

    private float[] flamex;
    private float[] flamey;

    private boolean left;
    private boolean right;
    private boolean up;

    private float maxSpeed;
    private float maxEnergy;
    private float acceleration;
    private float deceleration;
    private float acceleratingTimer;
    private float count = 1.5f;

    public static float b;
    public static float h;
    private Texture imgPlayer;
    private SpriteBatch sb;
    Sprite sprite;

    private Blackhole blackhole;

    public Player(ArrayList<Bullet> bullets) {

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            imgPlayer = new Texture(object.getChildByName("player").getAttribute("playertexture0"));
            sprite = new Sprite(imgPlayer);
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
        }

        this.bullets = bullets;
        sb = new SpriteBatch();

        // The Player starts on the midel of the screen.
        x = Gdx.graphics.getWidth() / 2;
        y = 50;

        width = 100;
        height = 100;
        maxSpeed = 300;
        maxEnergy = 100.0f;
        acceleration = 200;
        deceleration = 10;

        radians = 3.1415f / 2;
        rotationSpeed = 1.5f;
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
            //Set the rotationSpeed to count.          
            radians += rotationSpeed * dt;
            count += rotationSpeed;
        } else if (right) {
            radians -= rotationSpeed * dt; 

            count -= sprite.getX();;
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
        if (x > Gdx.graphics.getWidth()) {
            x = 0;
        }

        if (x < -3) {
            x = Gdx.graphics.getWidth();
        }

        x += vx * dt;

        if (y > Gdx.graphics.getHeight()) {
            //GOTO Next Level
            y = 0;
        }

        if (y <= 0 && up == true) {
            y = 5;
        } else if (y > -3) {
            y += vy * dt;
        }

        System.out.println("Count: " + count + " radians: " + radians);

//System.out.println("Player player x " +x +" player y " +y);
        // screen wrap
    }

    public void draw() {
        sb.begin();
        // Set the Player img to the Sprite.
        sprite.setTexture(imgPlayer);
        //Set the rotation of the Sprite.
        sprite.setRotation(count);
        sprite.getRotation();
        //Set the x and y positon of the Sprite.
        sprite.setPosition(x, y);
        //Set the x position of the Sprite.
        sprite.setX(vx);
        sprite.setY(vy);
        //Set the Sprite to the Centre.
        sprite.setCenter(x, y);
        //Draw the Sprite
        sprite.draw(sb);
        sb.end();
    }

}
