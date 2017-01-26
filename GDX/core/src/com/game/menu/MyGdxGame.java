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

    public MyGdxGame(SpaceLegends game) {
        this.game = game;
        batch = new SpriteBatch();
        imgPlayer = new Texture("badlogic.jpg");
        imgSchwarzesLoch = new Texture("badlogic.jpg");

    }

    @Override
    public void render(float delta) {
        
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                Gdx.app.exit();
            }
        
        player = new Player();
        schwarzesLoch = new SchwarzesLoch();
        
        player.movePlayerAll();
        player.koolisionFenster();
        
        schwarzesLoch.pullPlayer();
        
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

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
