package com.game.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.XmlReader;
import com.game.GameSettings.LevelLoader;
import com.game.managers.GameKeys;
import com.game.managers.GameStateManager;
import com.game.menu.MainMenu;
import com.game.obj.Blackhole;
import com.game.obj.BulletGegner;
import com.game.obj.BulletPlayer;
import com.game.obj.Gegner;
import com.game.obj.Player;
import com.mygdx.game.SpaceLegends;
import java.io.IOException;

public class PlayState extends GameState {

    private ShapeRenderer sr;

    private Blackhole blackhole;
    private Player player;
    private Gegner gegner;
    private ArrayList<BulletPlayer> bulletsPlayer;
    private ArrayList<BulletGegner> bulletsGegner;

    private SpriteBatch sb;
    public static Sprite sprite;
    public static Sprite sprite2;
    Texture Game_Over;
    Texture Gewonnen;
    public static int level = 1;
    public static boolean bk = false;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        LevelLoader levelloader;

        levelloader = new LevelLoader(level);

        sb = new SpriteBatch();
        sr = new ShapeRenderer();

        bulletsGegner = new ArrayList<BulletGegner>();
        bulletsPlayer = new ArrayList<BulletPlayer>();

        blackhole = new Blackhole();

        player = new Player(bulletsPlayer);

        gegner = new Gegner(bulletsGegner);

        try {
            XmlReader.Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            XmlReader.Element object = root.getChildByName("gameobjects");
            Game_Over = new Texture(object.getChildByName("gamescreen").getAttribute("gameovertexture"));
            Gewonnen = new Texture(object.getChildByName("gamescreen").getAttribute("gewonnentexture"));
            sprite = new Sprite(Game_Over);
            sprite2 = new Sprite(Gewonnen);
        } catch (IOException ex) {
            System.out.println("Bild wurde nicht geladen.");
        }

    }

    @Override
    public void update(float dt) {

        // Neues Spiel statrten oder Spiel beenden.
        if (!Player.playerLife && Gdx.input.isKeyJustPressed(Keys.ENTER)) {
            gsm.setState(1);
            gsm.draw();
            Player.playerLife = true;
            Gegner.gegnerLife = true;
        }

        if (!Player.playerLife && Gdx.input.isKeyJustPressed(Keys.BACKSPACE)) {
            System.out.println("Test");
            Gdx.app.exit();
        }

        // Naechstes level oder Spiel beenden.
        if (!Gegner.gegnerLife && Gdx.input.isKeyJustPressed(Keys.ENTER) && level < 5) {
            level++;

            gsm.setState(1);
            gsm.draw();
            Player.playerLife = true;
            Gegner.gegnerLife = true;
        } else if (level == 5) {
            System.out.println("Alles geschaft.");
        }

        if (Player.playerLife && !Gegner.gegnerLife && Gdx.input.isKeyJustPressed(Keys.BACKSPACE)) {
            System.out.println("Test");
            Gdx.app.exit();
        }

        // get user input
        handleInput();

        // update player
        player.update(dt);

        gegner.update(dt);
        // update blackhole
        blackhole.update();

        // Update Bullets Gegner
        for (int j = 0; j < bulletsGegner.size(); j++) {
            bulletsGegner.get(j).update(dt);
            if (bulletsGegner.get(j).shouldRemove()) {
                bulletsGegner.remove(j);
                j--;
            }
        }
//         update player bulletsPlayer
        for (int i = 0; i < bulletsPlayer.size(); i++) {
            bulletsPlayer.get(i).update(dt);
            if (bulletsPlayer.get(i).shouldRemove()) {
                bulletsPlayer.remove(i);
                i--;
            }
        }

        if (Player.playerLife && !Gegner.gegnerLife) {
            System.out.println("Gewonnen");
        } else if (!Player.playerLife && !Gegner.gegnerLife) {
            System.out.println("Verloren");
        } else if (!Player.playerLife) {
            System.out.println("Verloren");
        }

        //Player Aktion
        if (Player.pShoot && Gegner.boundingRectangle_Gegner.contains(Gegner.sprite.getX(), BulletPlayer.sprite.getY())) {
            System.out.println("Treffer  Gegner " + Player.pShoot);
            Gegner.maxEnergy = Gegner.maxEnergy - Player.getSchaden();
            System.out.println("gegner Energx" + Gegner.maxEnergy);
            Player.pShoot = false;
        }

        //Zusammen stoß mit gegner erkennen.
        if (Gegner.boundingRectangle_Gegner.contains(Player.px, Player.py) && Gegner.gegnerLife) {
            System.out.println("Zusammenstoß Gegner");
            Player.playerLife = false;
            Gegner.gegnerLife = false;
        }

        //Beruehrung mit schwarzenloch erkennen.
        if (Blackhole.boundingRectangle_Blackhole.contains(Player.px, Player.py)) {
            System.out.println("Zusammenstoß Schwarzesloch");
//            Player.px = 600;
//             Player.py = 50;
              drawGameOver();
            Player.playerLife = false;
        }

        //Gegner Aktion
        if (Gegner.gShoot && Player.boundingRectangle_Player.contains(BulletGegner.sx, Player.py) && Gegner.gegnerLife) {
            System.out.println("Treffer  Player " + Gegner.gShoot);
            Player.maxEnergy = Player.maxEnergy - Gegner.getSchaden();
            System.out.println("Player Energy " + Player.maxEnergy);
            Gegner.gShoot = false;
        }

    }

    @Override
    public void draw() {

        if (Gegner.gegnerLife && Player.playerLife) {
            // draw player
            player.draw();
            gegner.draw();

            // draw bulletsPlayer
            for (int i = 0; i < bulletsPlayer.size(); i++) {
                bulletsPlayer.get(i).draw();
            }
            // draw bulletsPlayer
            for (int j = 0; j < bulletsGegner.size(); j++) {
                bulletsGegner.get(j).draw();
            }
            blackhole.draw();

        } else if (!Player.playerLife) {
            drawGameOver();
        } else if (!Gegner.gegnerLife) {
            drawGewonnen();
        }
    }

    @Override
    public void handleInput() {
        player.setLeft(GameKeys.isDown(GameKeys.LEFT));
        player.setRight(GameKeys.isDown(GameKeys.RIGHT));
        player.setUp(GameKeys.isDown(GameKeys.UP));
        if (GameKeys.isPressed(GameKeys.SPACE)) {
            player.shoot();
        }
    }

    public void drawGewonnen() {
        sb.begin();
        // Set the Player img to the Sprite.
        sprite2.setTexture(Gewonnen);
        //Set the rotation of the Sprite.
//        sprite.setRotation(degrees);
        //Set the x and y positon of the Sprite.
//        sprite.setPosition(px, py);
        //Set the Sprite to the Centre.
//        sprite.setCenter(px, py);
        //Draw the Sprite
        sprite2.draw(sb);
        sb.end();
    }

    public void drawGameOver() {
        sb.begin();
        // Set the Player img to the Sprite.
        sprite.setTexture(Game_Over);
        //Set the rotation of the Sprite.
//        sprite.setRotation(degrees);
        //Set the x and y positon of the Sprite.
//        sprite.setPosition(px, py);
        //Set the Sprite to the Centre.
//        sprite.setCenter(px, py);
        //Draw the Sprite
        sprite.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {
    }

}
