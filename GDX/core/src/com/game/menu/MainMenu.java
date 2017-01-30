package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import static com.game.GameSettings.GameSettings.*;
import com.mygdx.game.SpaceLegends;
import com.game.Audio.Sounds;

public class MainMenu implements Screen {

    // Groesse der schaltflaechen.
    private final int buton_size_heigth = 80;
    private final int buton_size_width = 230;

    private final int Title_banner_size_heigth = 400;
    private final int Title_Banner_size_width = 1200;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    // position der schaltflaeche und des Banners.

    // y positionen der bilder.
    private int Title_Banner_y = 450;
    private int Start_buton_y = 200;
    private int Option_buton_y = 70;
    private int Exit_buton_y = -70;

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

    private int select = 0;

    final SpaceLegends game;

    Texture Low_Resoulution;
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
        Low_Resoulution = new Texture("low_resoulution.png");
        Background = new Texture("background.png");
        Start_enabled = new Texture("start_enabled.png");
        Start_disabled = new Texture("start_disabled2.png");
        Exit_enabled = new Texture("aktiv.png");
        Exit_disabled = new Texture("inaktiv.png");
        Option_enabled = new Texture("Optionen_enabled.jpg");
        Option_disabled = new Texture("Optionen_disabled.jpg");
        Title_Banner = new Texture("SpaceLegendd.png");

        MainMenu mainMenuScreen = this;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed((Keys.DPAD_DOWN)) && select < 3) {
            select++;
        } else if (select == 3) {
            select = 0;
        }

        if (Gdx.input.isKeyJustPressed((Keys.DPAD_UP)) && select > -1) {
            select--;
        }else if (select == -1) {
            select = 2;
        }
        
        
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        getScreenResoulution();

        game.batch.end();
        com.game.GameSettings.WindowMode.setWindowMode();

    }

    public void getScreenResoulution() {

        // Auflösung für den Volbildmodus festlegen.
        if (Main_Frame_fullscreen) {

            // halbe biltschirm goesse ermiteln.
            screen_heigth = (Gdx.graphics.getHeight()) / 2;
            screen_width = (Gdx.graphics.getWidth()) / 2;

            //Titel banner position anpassen.
            Banner_Width = Title_Banner_size_width / 2;
            Banner_x = screen_width - Banner_Width + 5;

            Banner_heigth = Title_banner_size_heigth / 2;

            // berechnen das die butons immer in der mitte sind.
            buton_Width = buton_size_width / 2;
            buton_x = screen_width - buton_Width + 5;

            buton_heigth = buton_size_heigth / 2;

        }

        //Monitor aufloesung festlegen und zu kleine aufloesung verhindern
        if (Gdx.graphics.getHeight() < 768 && Gdx.graphics.getWidth() < 1024) {
            game.batch.draw(Low_Resoulution, Background_size_x, Background_size_y);

        } else if (Gdx.graphics.getHeight() <= 768) {
            Banner_y = screen_heigth + Banner_heigth - 90;
            buton_y = screen_heigth - buton_heigth + 2;
            Title_Banner_y = 250;
            Start_buton_y = 100;
            Option_buton_y = -30;
            Exit_buton_y = -160;

            selectMenu();

        } else if (Main_Frame_fullscreen) {
            Banner_y = screen_heigth + Banner_heigth + 50;
            buton_y = screen_heigth - buton_heigth + 50;

            selectMenu();

        } else {
            Banner_y = screen_heigth + Banner_heigth + 330;
            buton_y = screen_heigth - buton_heigth + 180;

            selectMenu();
        }

    }

    /**
     * Erzeugt die Butons für das haupt menue und das pause menue
     */
    public void selectMenu() {

        switch (select) {
            // Case -1 zeichnet den letzten buton 
            case -1:
                game.batch.draw(Background, Background_size_x, Background_size_y);
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Start_disabled, buton_x, buton_y + Start_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_disabled, buton_x, buton_y + Option_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_enabled, buton_x, buton_y + Exit_buton_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    Gdx.app.exit();
                }
                break;
            case 0:
                game.batch.draw(Background, Background_size_x, Background_size_y);
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Start_enabled, buton_x, buton_y + Start_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_disabled, buton_x, buton_y + Option_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_disabled, buton_x, buton_y + Exit_buton_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    game.setScreen(new MyGdxGame(game));
                }
                break;
            case 1:
                game.batch.draw(Background, Background_size_x, Background_size_y);
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Start_disabled, buton_x, buton_y + Start_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_enabled, buton_x, buton_y + Option_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_disabled, buton_x, buton_y + Exit_buton_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    game.setScreen(new OptionMenu(game));
                    saveGameSetings();
                }
                break;
            case 2:
                game.batch.draw(Background, Background_size_x, Background_size_y);
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Start_disabled, buton_x, buton_y + Start_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_disabled, buton_x, buton_y + Option_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_enabled, buton_x, buton_y + Exit_buton_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    Gdx.app.exit();
                }
                break;
                // Case 3 Zeichnet den ersten buton.
            case 3:
                game.batch.draw(Background, Background_size_x, Background_size_y);
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Start_disabled, buton_x, buton_y + Start_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_disabled, buton_x, buton_y + Option_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_enabled, buton_x, buton_y + Exit_buton_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    Gdx.app.exit();
                }
                break;
            default:
                break;
        }
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
