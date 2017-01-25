package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.SpaceLegends;
import static com.game.GameSetings.GameSetings.getRelease;
import static com.game.GameSetings.GameSetings.getMain_Frame_Title;

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
    private final int buton_size_heigth = 70;
    private final int buton_size_width = 220;

    private final int Title_banner_size_heigth = 100;
    private final int Title_Banner_size_width = 600;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    // position der schaltflaeche und des Banners.

    // y positionen der bilder.
    private int Title_Banner_y = 450;
    private int Start_buton_y = 250;
    private int Option_buton_y = 150;
    private int Exit_buton_y = 50;

    //
    private int buton_Width = 0;
    private int buton_heigth = 0;

    private int Banner_Width = 0;
    private int Banner_heigth = 0;

    private int Banner_x = 0;
    private int Banner_y = 0;
    private int buton_x = 0;
    private int buton_y = 0;

    private int screen_width = 0;
    private int screen_heigth = 0;

    final SpaceLegends game;

    Texture Background;
    Texture Title_Banner;
    Texture Start_enabled;
    Texture Exit_enabled;
    Texture Option_enabled;

    Texture Start_disabled;
    Texture Exit_disabled;
    Texture Option_disabled;

    public MainMenu(SpaceLegends game) {
        this.game = game;

        // platzhalter bilder werden geladen.
        Background = new Texture("background.png");
        Start_enabled = new Texture("start_disabled.png");
        Start_disabled = new Texture("inaktiv.png");
        Exit_enabled = new Texture("aktiv.png");
        Exit_disabled = new Texture("inaktiv.png");
        Option_enabled = new Texture("aktiv.png");
        Option_disabled = new Texture("inaktiv.png");
        Title_Banner = new Texture("aktiv.png");

        MainMenu mainMenuScreen = this;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.graphics.isFullscreen()) {
            if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
                System.exit(0);
            }
        }

        if (Gdx.input.isKeyJustPressed((Keys.DPAD_UP))) {

        }

        //Gdx.graphics.setTitle(getMain_Frame_Title() + "Main Menu" + getRelease());
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        // halbe biltschirm goesse ermiteln.
        screen_heigth = (Gdx.graphics.getHeight()) / 2;
        screen_width = (Gdx.graphics.getWidth() / 2);

        //Titel banner position anpassen.
        Banner_Width = Title_Banner_size_width / 2;
        Banner_x = screen_width - Banner_Width + 5;

        Banner_heigth = Title_banner_size_heigth / 2;

        // berechnen das die butons immer in der mitte sind.
        buton_Width = buton_size_width / 2;
        buton_x = screen_width - buton_Width + 5;

        buton_heigth = buton_size_heigth / 2;

        if(Gdx.graphics.getHeight() < 768){
           game.batch.draw(Background, Background_size_x, Background_size_y); 
           game.batch.end();
        }
        else if (Gdx.graphics.getHeight() < 800) {
            Banner_y = screen_heigth + Banner_heigth + 200;
            buton_y = screen_heigth - buton_heigth;
            Title_Banner_y = 450;
            Start_buton_y = 140;
            Option_buton_y = 40;
            Exit_buton_y = -60;

        } else {
            Banner_y = screen_heigth + Banner_heigth + 350;
            buton_y = screen_heigth - buton_heigth + 5;
        }

        // platz halter werden aus gegeben.
        game.batch.draw(Background, Background_size_x, Background_size_y);
        game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
        game.batch.draw(Start_enabled, buton_x, buton_y + Start_buton_y, buton_size_width, buton_size_heigth);
        game.batch.draw(Option_enabled, buton_x, buton_y + Option_buton_y, buton_size_width, buton_size_heigth);
        game.batch.draw(Exit_enabled, buton_x, buton_y + Exit_buton_y, buton_size_width, buton_size_heigth);

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
