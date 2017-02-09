package com.game.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.managers.GameKeys;
import com.game.managers.GameStateManager;
import com.game.obj.Blackhole;
import com.game.obj.Bullet;
import com.game.obj.Player;

public class PlayState extends GameState {

    private ShapeRenderer sr;

    private Blackhole blackhole;
    private Player player;
    private ArrayList<Bullet> bullets;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {

        sr = new ShapeRenderer();

        bullets = new ArrayList<Bullet>();

        blackhole = new Blackhole();

        player = new Player(bullets);

    }

    public void update(float dt) {

        // get user input
        handleInput();

        // update player
        player.update(dt);
        blackhole.update();
        // update player bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update(dt);
            if (bullets.get(i).shouldRemove()) {
                bullets.remove(i);
                i--;
            }
        }

    }

    public void draw() {

        // draw player
        player.draw();
        blackhole.draw();
        // draw bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw();
        }

    }

    public void handleInput() {
        player.setLeft(GameKeys.isDown(GameKeys.LEFT));
        player.setRight(GameKeys.isDown(GameKeys.RIGHT));
        player.setUp(GameKeys.isDown(GameKeys.UP));
        if (GameKeys.isPressed(GameKeys.SPACE)) {
            player.shoot();
        }
    }

    public void dispose() {
    }

}
