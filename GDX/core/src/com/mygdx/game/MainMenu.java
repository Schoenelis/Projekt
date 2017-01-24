package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 * Erstellt ein Hauptmenue
 * @author Dreissa
 */

public class MainMenu implements Screen {
    
    // Groesse der schaltflaechen.
    private final int width = 200;
    private final int heigth = 70;
    
    // position der schaltflaeche.
    private final int x = 300;
    private final int y = 150;
    private  int butonWidth=0;

    final SpaceLegends game;

    Texture Start_enabled;
    Texture Ende_enabled;
    Texture Einstelungen_enabled;

    Texture Start_disabled;
    Texture Ende_disabled;
    Texture Einstelungen_disabled;

    public MainMenu(SpaceLegends game) {
        this.game = game;
        Start_enabled = new Texture("badlogic.jpg");
//        Start_disabled = new Texture("");
//        Ende_enabled = new Texture("");
//        Ende_disabled = new Texture("");
//        Einstelungen_enabled = new Texture("");
//        Einstelungen_disabled = new Texture("");

        MainMenu mainMenuScreen = this;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        butonWidth = Start_enabled.getWidth() / 2;
 
        
        game.batch.draw(Start_enabled, x, y, width, heigth);

        game.batch.end();

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

    @Override
    public void dispose() {
        game.dispose();
    }

}
