package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dreissa
 */
public class Gegner extends GameObj {

    private final int MAX_BULLETS = 1;
    private ArrayList<BulletGegner> bullets;

    private boolean left;
    private boolean right;
    private boolean up;

    private float maxSpeed;
    public static float maxEnergy;
    private float degrees;

    public static float gx;
    public static float gy;
    public static float gvx;
    public static float gvy;

    private Texture imgGegner;
    private final SpriteBatch sb;
    public static Sprite sprite;

    float radians;
    float rotationSpeed;
    public static int height;
    public static int width;
    public static boolean gegnerLife = true;
    public boolean leftTurn = false;
    public boolean rightTurn = false;
    public static boolean gShoot = false;
    public static Rectangle boundingRectangle_Gegner;
    public static float schaden;

    
    public static float getSchaden() {
        return schaden;
    }

    public static void setSchaden(float schaden) {
        Gegner.schaden = schaden;
    }

    public static void setMaxEnergy(float maxEnergy) {
        Gegner.maxEnergy = maxEnergy;
    }

    public static void setGy(float gy) {
        Gegner.gy = Gdx.graphics.getHeight() - gy;
    }

    public Gegner(ArrayList<BulletGegner> bullets) {

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            imgGegner = new Texture(object.getChildByName("gegner").getAttribute("gegnertexture0"));
            sprite = new Sprite(imgGegner);
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
        }

        this.bullets = bullets;
        sb = new SpriteBatch();

        // The Player starts on the center of the screen.
        gx = Player.px;
//        gy = Gdx.graphics.getHeight() - 50;

        width = 50;
        height = 50;
        maxSpeed = 290;
        maxEnergy = 100.0f;

        radians = 3.1415f / 2;

    }

    public void shoot() {

        if (bullets.size() == MAX_BULLETS) {
            return;
        }
        gShoot = true;
        bullets.add(new BulletGegner(gx, gy, radians * -1));

    }

    public void update(float dt) {
        boundingRectangle_Gegner = Gegner.sprite.getBoundingRectangle();
        if (maxEnergy <= 0) {
            gegnerLife = false;

        }

      

     
        if (Gdx.input.isKeyJustPressed(Keys.S) && Gdx.input.isKeyJustPressed(Keys.NUM_1) && Gdx.input.isKeyJustPressed(Keys.L)) {         
                gegnerLife = false;
            }

            // player verfolgung
            if (Player.px - 1 > gx) {
                gx++;
            } else if (Player.px + 1 < gx) {
                gx--;
            }

            if (Player.px == gx || gx - 5 <= Player.px || gx + 5 >= Player.px) {
                shoot();
            }

            // set position
            if (gx
                    > Gdx.graphics.getWidth()) {
                gx = 0;
            }

            if (gx
                    < -3) {
                gx = Gdx.graphics.getWidth();
            }

            //System.out.println("x " + pvx + "y " + pvy);
            //degrees = (float) Math.toDegrees(radians);
            // screen wrap
        }

    

    public void draw() {
        sb.begin();
        // Set the Player img to the Sprite.
        sprite.setTexture(imgGegner);
        //Set the rotation of the Sprite.
//       sprite.setRotation(degrees);
        //Set the x and y positon of the Sprite.
        sprite.setPosition(gx, gy);
        //Set the Sprite to the Centre.
        sprite.setCenter(gx, gy);
        //Draw the Sprite
        sprite.draw(sb);
        sb.end();
    }
}
