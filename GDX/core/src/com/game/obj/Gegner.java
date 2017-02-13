package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.XmlReader;
import static com.game.obj.Player.pShoot;
import static com.game.obj.Player.px;
import static com.game.obj.Player.py;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dreissa
 */
public class Gegner extends GameObj {

    private final int MAX_BULLETS = 4;
    private ArrayList<Bullet> bullets;

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

    public Gegner(ArrayList<Bullet> bullets) {

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
        gy = Gdx.graphics.getHeight() - 50;

        width = 100;
        height = 100;
        maxSpeed = 200;
        maxEnergy = 100.0f;

        radians = 3.1415f / 2;

    }

    public void shoot(){
        
        if (bullets.size() == MAX_BULLETS) {
            return;
        }
        gShoot = true;
        bullets.add(new Bullet(gx, gy, radians * -1));
        
    }

    public void update(float dt) {

        if (Gdx.input.isKeyJustPressed(Keys.T) || maxEnergy == 0) {
            gegnerLife = false;
           
        }

        // player verfolgung
        if (Player.px - 1 > gx) {
            gx++;
        } else if (Player.px + 1 < gx) {
            gx--;
        }

        if (Player.px == gx) {
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
