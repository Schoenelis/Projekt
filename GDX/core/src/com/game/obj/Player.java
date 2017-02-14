package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;

public class Player extends SpaceObject {

    private final int MAX_BULLETS = 4;
    private ArrayList<BulletPlayer> bullets;

    private boolean left;
    private boolean right;
    private boolean up;

    private float maxSpeed;
    public static float maxEnergy;
    private float acceleration;
    private float deceleration;
    private float acceleratingTimer;
    private float degrees;

    public static float px;
    public static float py;
    public static float pvx;
    public static float pvy;

    private Texture imgPlayer;
    private final SpriteBatch sb;
    public static Sprite sprite;

    float radians;
    float rotationSpeed;
    public static int height;
    public static int width;
    public static boolean pShoot;
    public static boolean playerLife;
    public static boolean Collision;
    public static Rectangle boundingRectangle_Player;

    public Player(ArrayList<BulletPlayer> bullets) {

        px = x;
        py = y;

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

        // The Player starts on the center of the screen.
        px = Gdx.graphics.getWidth() / 2;
        py = 50;

        width = 100;
        height = 100;
        maxSpeed = 200;
        maxEnergy = 100;
        acceleration = 200;
        deceleration = 10;

        playerLife = true;
        pShoot = false;
        Collision = false;

        radians = 3.1415f / 2;
        rotationSpeed = 0.9f;
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
        pShoot = true;
        bullets.add(new BulletPlayer(px, py, radians));
    }

    public void update(float dt) {

        boundingRectangle_Player = sprite.getBoundingRectangle();

        if (Gdx.input.isKeyJustPressed(Keys.Z) || maxEnergy <= 0) {
            playerLife = false;
        }

        // turning
        if (left) {
            //Set the rotationSpeed to count.  
            radians += rotationSpeed * dt;
        } else if (right) {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if (up) {
            pvx += MathUtils.cos(radians) * acceleration * dt;
            pvy += MathUtils.sin(radians) * acceleration * dt;
            acceleratingTimer += dt;
            if (acceleratingTimer > 0.1f) {
                acceleratingTimer = 0;
            }
        } else {
            acceleratingTimer = 0;
        }

        // deceleration
        float vec = (float) Math.sqrt(pvx * pvx + pvy * pvy);

        if (vec > 0) {
            pvx -= (pvx / vec) * deceleration * dt;
            pvy -= (pvy / vec) * deceleration * dt;
        }

        if (vec > maxSpeed) {
            pvx = (pvx / vec) * maxSpeed;
            pvy = (pvy / vec) * maxSpeed;
        }

        // set position
        if (px > Gdx.graphics.getWidth()) {
            px = 0;
        }

        x += pvx * dt;

        if (px < -3) {
            px = Gdx.graphics.getWidth();
        }

        px += pvx * dt;

        if (Gegner.gegnerLife) {
            if (py > Gdx.graphics.getHeight()) {
                py = Gdx.graphics.getHeight();
            }
        } else if (py > Gdx.graphics.getHeight()) {
            //GOTO Next Level
            py = 0;
        }

        if (py <= 0 && up == true) {
            py = 5;
        } else if (py > -3) {
            py += pvy * dt;
        }

        degrees = (float) Math.toDegrees(radians);
        // screen wrap
    }

    public void draw() {
        sb.begin();
        // Set the Player img to the Sprite.
        sprite.setTexture(imgPlayer);
        //Set the rotation of the Sprite.
        sprite.setRotation(degrees);
        //Set the x and y positon of the Sprite.
        sprite.setPosition(px, py);
        //Set the Sprite to the Centre.
        sprite.setCenter(px, py);
        //Draw the Sprite
        sprite.draw(sb);
        sb.end();
    }

}
