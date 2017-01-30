/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.game.Audio.Sounds;
import com.game.GameSettings.GameSettings;
import static com.game.GameSettings.GameSettings.Main_Frame_fullscreen;
import static com.game.GameSettings.GameSettings.*;
import com.mygdx.game.SpaceLegends;

/**
 *
 * @author dreissa
 */
public class OptionMenu implements Screen {

    final SpaceLegends game;

    private int select = 0;
    private int menuButonId = 0;
    private int gameButonId = 1;

    // Groesse der schaltflaechen.
    private final int buton_size_heigth = 80;
    private final int buton_size_width = 230;

    private final int Title_banner_size_heigth = 400;
    private final int Title_Banner_size_width = 1200;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    // position der schaltflaeche und des Banners.

    // y positionen der bilder.
    private int Title_Banner_y = 200;
    private int Menu_Volume_buton_y = 250;
    private int Game_Volume_buton_y = 150;
    private int About_game_buton_y = 50;
    private int Exit_With_Out_Save_buton_y = -50;
    private int Exit_And_Save_buton_y = -150;

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

    int Menu_Volume_Value = (int) (GameSettings.getMenu_Volume() * 100);;
    float Menu_Volume =  GameSettings.getMenu_Volume();
    int Game_Volume_Value = 80;

    Texture Title_Banner;
    Texture Background;
    Texture Menu_Background;
    Texture Volume_Buton_Not_Selcted;
    Texture Menu_Volume_Buton;
    Texture Game_Volume_Buton;
    Texture About_Game;
    Texture Exit_With_Out_Save;
    Texture Exit_And_Save;

    Texture About_Game2;
    Texture Exit_With_Out_Save2;
    Texture Exit_And_Save2;

    //xture Option_disabled;
    public OptionMenu(SpaceLegends game) {
        this.game = game;

        // platzhalter bilder werden geladen.
        Title_Banner = new Texture("SpaceLegend.png");

        Background = new Texture("background.png");

//        //Menu_Background = new Texture("Menu_background.png");
        Menu_Volume_Buton = new Texture("Volume_Butons/Volume_" + Menu_Volume_Value + ".png");

        Game_Volume_Buton = new Texture("Volume_Butons/Volume_" + Game_Volume_Value + ".png");

        Volume_Buton_Not_Selcted = new Texture("Volume_Butons/Volume_Not_Selected.png");

        About_Game = new Texture("inaktiv.png");

        Exit_With_Out_Save = new Texture("inaktiv.png");

        Exit_And_Save = new Texture("inaktiv.png");

        About_Game2 = new Texture("aktiv.png");

        Exit_With_Out_Save2 = new Texture("aktiv.png");

        Exit_And_Save2 = new Texture("aktiv.png");

        OptionMenu optionMenu = this;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_DOWN)) && select < 4) {
            select++;
        }
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_UP)) && select > 0) {
            select--;
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 0 && Menu_Volume_Value < 100) {
            Menu_Volume += 0.2f;
            Sounds.setMenu_Volume(1f);
            for (int i = 0; i < 10; i++);
            GameSettings.setMenu_Volume(Menu_Volume);
            Menu_Volume_Value = (int) (100 * Menu_Volume);
            setVolume(menuButonId);

            System.out.println("Menue_Volume_Value: " + Menu_Volume_Value  + " Menue_Volume: " + Menu_Volume);

        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 0 && Menu_Volume_Value > 0) {
            Menu_Volume_Value -= 20;

            if (Menu_Volume_Value == 0) {
                Menu_Volume = 0f;
            } else {
                Menu_Volume -= 0.2f;
            }

            Sounds.setMenu_Volume(Menu_Volume);
            setVolume(menuButonId);

            System.out.println("Menu_Volume_Value: " + Menu_Volume_Value + " Menu_Volume: " + Menu_Volume);
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 1 && Game_Volume_Value < 100) {
            Game_Volume_Value += 20;
            setVolume(gameButonId);
        }
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 1 && Game_Volume_Value > 0) {
            Game_Volume_Value -= 20;
            setVolume(gameButonId);
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        getScreenResoulution();

        game.batch.end();
        com.game.GameSettings.WindowMode.setWindowMode();

    }

    /**
     * Erzeugt die Butons für das haupt menue und das pause menue
     */
    public void selectMenu() {

        switch (select) {
            case 0:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //  game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Buton, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Game_Volume_Buton, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(About_Game, buton_x, buton_y + About_game_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_With_Out_Save, buton_x, buton_y + Exit_With_Out_Save_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_And_Save, buton_x, buton_y + Exit_And_Save_buton_y, buton_size_width, buton_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    Gdx.app.exit();
                }
                break;
            case 1:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Buton, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Game_Volume_Buton, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(About_Game, buton_x, buton_y + About_game_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_With_Out_Save, buton_x, buton_y + Exit_With_Out_Save_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_And_Save, buton_x, buton_y + Exit_And_Save_buton_y, buton_size_width, buton_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                }
                break;
            case 2:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Buton, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Game_Volume_Buton, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(About_Game2, buton_x, buton_y + About_game_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_With_Out_Save, buton_x, buton_y + Exit_With_Out_Save_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_And_Save, buton_x, buton_y + Exit_And_Save_buton_y, buton_size_width, buton_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                    saveGameSettings();
                }
                break;
            case 3:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Buton, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Game_Volume_Buton, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(About_Game, buton_x, buton_y + About_game_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_With_Out_Save2, buton_x, buton_y + Exit_With_Out_Save_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_And_Save, buton_x, buton_y + Exit_And_Save_buton_y, buton_size_width, buton_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                    LoadGameSettings();
                }
                break;
            case 4:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Buton, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Menu_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Game_Volume_Buton, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Volume_Buton_Not_Selcted, buton_x, buton_y + Game_Volume_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(About_Game, buton_x, buton_y + About_game_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_With_Out_Save, buton_x, buton_y + Exit_With_Out_Save_buton_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_And_Save2, buton_x, buton_y + Exit_And_Save_buton_y, buton_size_width, buton_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    Gdx.app.exit();
                }
                break;

            default:
                break;
        }
    }

    /**
     * Zeichnet die Butons fuer die Lautstaerke neu.
     *
     * Die zu zeichneden butons werden mittels der butonId aus gewaehlt und dann
     * gezeichnet.
     *
     * @param butonId
     */
    public void setVolume(int butonId) {
        switch (butonId) {
            case 0:
                butonId = 0;
                Menu_Volume_Buton = new Texture("Volume_Butons/Volume_" + Menu_Volume_Value + ".png");

                break;

            case 1:
                butonId = 2;
                Game_Volume_Buton = new Texture("Volume_Butons/Volume_" + Game_Volume_Value + ".png");
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
        game.batch.dispose();
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

        if (Gdx.graphics.getHeight() <= 768) {
            Banner_y = screen_heigth + Banner_heigth - 90;
            buton_y = screen_heigth - buton_heigth + 2;
            Title_Banner_y = 250;
            Menu_Volume_buton_y = 100;
            Game_Volume_buton_y = -30;
            About_game_buton_y = -160;
            Exit_With_Out_Save_buton_y = -200;
            Exit_And_Save_buton_y = -250;

            selectMenu();

        } else if (Main_Frame_fullscreen) {
            Banner_y = screen_heigth + Banner_heigth;
            buton_y = screen_heigth - buton_heigth;

            selectMenu();

        } else {
            Banner_y = screen_heigth + Banner_heigth + 330;
            buton_y = screen_heigth - buton_heigth + 180;

            selectMenu();
        }

    }

}
