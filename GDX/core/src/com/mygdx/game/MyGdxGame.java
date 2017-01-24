package com.mygdx.game;

import com.mygdx.game.obj.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture imgPlayer;
    Texture imgSchwarzesLoch;
    Bewegung bewegung;
    Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgPlayer = new Texture("badlogic.jpg");
        imgSchwarzesLoch = new Texture("schwarzesLoch.jpg");
    }

    @Override
    public void render() {
        bewegung = new Bewegung();
        player = new Player();
        
        bewegung.steuerung();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        
        batch.draw(imgSchwarzesLoch, 100, 100);
        batch.draw(imgPlayer, Bewegung.playerX, Bewegung.playerY, player.getPlayerwidth(), player.getPlayerheight());

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgPlayer.dispose();
        imgSchwarzesLoch.dispose();
    }
}
