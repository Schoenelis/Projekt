package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.SpaceLegends;

/**
 * Erstellt ein Hauptmenu Fenster.
 *
 * Erstellt ein Hauptmenue Fenster wo derr spieler zwischen Spielstarten,
 * Einstelungen oder Spielbenden waehlen kann.
 *
 * @author Dreissa
 * @version 0.01
 */
public class MainMenu implements Screen {

    // Groesse der schaltflaechen.
    private final int width = 200;
    private final int heigth = 70;

    // position der schaltflaeche und des Banners.
    private final int Title_Banner_x = 180;
    private final int Title_Banner_y = 500;

    private final int buton_x = 180;
    
    private final int Start_buton_y = 350;

    private final int Option_buton_y = 250;

    private final int Exit_buton_y = 150;

    private int butonWidth = 0;

    final SpaceLegends game;

    Texture Title_Banner;
    Texture Start_enabled;
    Texture Exit_enabled;
    Texture Option_enabled;

    Texture Start_disabled;
    Texture Exit_disabled;
    Texture Option_disabled;

    public MainMenu(SpaceLegends game) {
        this.game = game;

        Start_enabled = new Texture("badlogic.jpg");
//        Start_disabled = new Texture("");
//        Ende_enabled = new Texture("");
//        Ende_disabled = new Texture("");
//        Einstelungen_enabled = new Texture("");
//        Einstelungen_disabled = new Texture("");
//          Title_Banner = new Texture("");

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

        // platz halter werden aus gegeben.
        game.batch.draw(Start_enabled, Title_Banner_x, Title_Banner_y, width, heigth);
        game.batch.draw(Start_enabled, buton_x, Start_buton_y, width, heigth);
        game.batch.draw(Start_enabled, buton_x, Option_buton_y, width, heigth);
        game.batch.draw(Start_enabled, buton_x, Exit_buton_y, width, heigth);

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
