package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.obj.Player;
import com.game.obj.SchwarzesLoch;
import com.mygdx.game.SpaceLegends;

/**
 *
 * @author info
 */
public class MyGdxGame implements Screen {

    final SpaceLegends game;
    SpriteBatch batch;
    Texture imgPlayer;
    Texture imgSchwarzesLoch;
    SchwarzesLoch schwarzesLoch;
    Player player;
    Texture Background;
    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    boolean paused = false;

    public MyGdxGame(SpaceLegends game) {
        this.game = game;
        batch = new SpriteBatch();
        imgPlayer = new Texture("badlogic.jpg");
        imgSchwarzesLoch = new Texture("badlogic.jpg");
        Background = new Texture("Game_Grafiken/background.png");

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
            game.setScreen(new MainMenu(game));
        } 


        player = new Player();
        schwarzesLoch = new SchwarzesLoch();

        player.movePlayerAll();
        player.koolisionFenster();

        schwarzesLoch.pullPlayer();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(Background, Background_size_x, Background_size_y);
        game.batch.draw(imgPlayer, Player.x, Player.y, Player.width, Player.height);
        game.batch.draw(imgSchwarzesLoch, SchwarzesLoch.x, SchwarzesLoch.y, SchwarzesLoch.width, SchwarzesLoch.height);

        game.batch.end();
    }

    @Override
    public void dispose() {
        game.dispose();
        imgPlayer.dispose();
        imgSchwarzesLoch.dispose();
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
