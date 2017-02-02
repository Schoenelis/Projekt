package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.game.obj.Blackhole;
import com.game.obj.Bullet;
import com.game.obj.Player;

import com.mygdx.game.SpaceLegends;
import java.util.ArrayList;

public class MyGdxGame implements Screen {

    final SpaceLegends game;
    Player player;
    Blackhole blackhole;
    private ArrayList<Bullet> bullets;
    Bullet bullet;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    boolean paused = false;

    public MyGdxGame(SpaceLegends game) {
        this.game = game;
        player = new Player(bullets);
        blackhole = new Blackhole();
        bullets = new ArrayList<Bullet>();
        bullet = new Bullet();

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
            game.setScreen(new MainMenu(game));
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update();
        player.draw();

        blackhole.update();
        blackhole.draw();

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).isRemove()) {
                bullets.remove(i);
                i--;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (bullets.size() == Player.MAX_BULLETS) {
                return;
            }
            bullet.draw();
            bullets.add(new Bullet());
        }

    }

    @Override
    public void dispose() {
        game.dispose();

    }

    @Override
    public void show() {
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }
}
