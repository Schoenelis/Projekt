package com.game.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.game.managers.GameKeys;
import com.game.managers.GameStateManager;
import com.game.obj.Blackhole;
import com.game.obj.Bullet;
import com.game.obj.Gegner;
import com.game.obj.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayState extends GameState {

    private ShapeRenderer sr;

    private Blackhole blackhole;
    private Player player;
    private Gegner gegner;
    private ArrayList<Bullet> bullets;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        sr = new ShapeRenderer();

        bullets = new ArrayList<Bullet>();

        blackhole = new Blackhole();
        player = new Player(bullets);

        gegner = new Gegner(bullets);

    }

    @Override
    public void update(float dt) {

        // get user input
        handleInput();

        // update player
        player.update(dt);

        gegner.update(dt);
        // update blackhole
        blackhole.update();
//         update player bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update(dt);
            if (bullets.get(i).shouldRemove()) {
                bullets.remove(i);
                i--;
            }
        }

        Rectangle boundingRectangle0 = Gegner.sprite.getBoundingRectangle();
        Rectangle boundingRectangle1 = Bullet.sprite.getBoundingRectangle();
        Rectangle boundingRectangle2 = Player.sprite.getBoundingRectangle();
        Rectangle boundingRectangle3 = Bullet.sprite.getBoundingRectangle();
        Rectangle boundingRectangle4 = Blackhole.sprite.getBoundingRectangle();

        if (Player.playerLife && !Gegner.gegnerLife) {
            System.out.println("Gewonnen");
        } else if (!Player.playerLife && !Gegner.gegnerLife) {
            System.out.println("Verloren");
        } else if (!player.playerLife) {
            System.out.println("Verloren");
        }

        //Player Aktion
        if (player.pShoot && boundingRectangle1.overlaps(boundingRectangle0)) {
            System.out.println("Treffer  " + player.pShoot);
            Gegner.maxEnergy -= 10;
            player.pShoot = false;
        }

        if (player.Collision &&boundingRectangle2.overlaps(boundingRectangle0)) {
            System.out.println("Zusammenstoß");
            gegner.maxEnergy = 0;
            player.maxEnergy = 0;
        }

        if (boundingRectangle2.overlaps(boundingRectangle4)) {
            System.out.println("Zusammenstoß Schwartzes loch");
            Player.px = 600;
            Player.py = 50;
            Player.playerLife =false;
        }

        //Gegner Aktion
        if (gegner.gShoot && boundingRectangle2.contains(gegner.gx, player.py)) {
            gegner.shoot();
        }

        if (gegner.gShoot && boundingRectangle2.overlaps(boundingRectangle3)) {
            System.out.println("Treffer  " + gegner.gShoot);
            gegner.gShoot = false;
            player.maxEnergy -= 0.5f;
        }

    }

    @Override
    public void draw() {
        if (Gegner.gegnerLife) {
            // draw player
            player.draw();

            blackhole.draw();
            // draw bullets
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).draw();
            }
            gegner.draw();
        } else {
            // draw player
            player.draw();

            blackhole.draw();
            // draw bullets
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).draw();
            }
           // gegner.draw();
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

    @Override
    public void dispose() {
    }

}
