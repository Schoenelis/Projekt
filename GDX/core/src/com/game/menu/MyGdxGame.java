package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Bewegung;
import com.mygdx.game.SpaceLegends;
import com.mygdx.game.obj.Player;

/**
 *
 * @author info
 */
public class MyGdxGame implements Screen {

    final SpaceLegends game;
    SpriteBatch batch;
    Texture imgPlayer;
    Texture imgSchwarzesLoch;
    Bewegung bewegung;
    Player player;

    public MyGdxGame(SpaceLegends game) {
        this.game = game;
        batch = new SpriteBatch();
        imgPlayer = new Texture("badlogic.jpg");
        // imgSchwarzesLoch = new Texture("schwarzesLoch.jpg")
    }

    @Override
    public void render(float delta) {
        bewegung = new Bewegung();
        player = new Player();

        bewegung.steuerung();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        // game.batch.draw(imgSchwarzesLoch, 100, 100);
        game.batch.draw(imgPlayer, Bewegung.playerX, Bewegung.playerY, player.getPlayerwidth(), player.getPlayerheight());

        game.batch.end();
    }

    @Override
    public void dispose() {
        game.dispose();
        imgPlayer.dispose();
        //imgSchwarzesLoch.dispose();
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
