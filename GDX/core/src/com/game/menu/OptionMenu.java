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
    private final int menuButtonId = 0;
    private final int gameButtonId = 1;
    private final int sfxButtonId = 2;

    // Groesse der schaltflaechen.
    private final int button_size_heigth = 80;
    private final int button_size_width = 230;

    private final int Title_banner_size_heigth = 400;
    private final int Title_Banner_size_width = 1200;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    // position der schaltflaeche und des Banners.

    // y positionen der bilder.
    private int Title_Banner_y = 200;
    private int Menu_Volume_button_y = 250;
    private int Game_Volume_button_y = 150;
    private int Game_SFX_Volume_button_y = 50;
    private int About_game_button_y = -50;
    private int New_Game_y = -150;
    private int Exit_And_Save_button_y = -250;

    //
    private int button_Width = 0;
    private int button_heigth = 0;

    private int Banner_Width = 0;
    private int Banner_heigth = 0;

    private int Banner_x = 0;
    private int Banner_y = 0;
    private int button_x = 0;
    private int button_y = 0;

    private int screen_width = 0;
    private int screen_heigth = 0;

    int Menu_Volume_Value = (int) (GameSettings.getMenu_Volume() * 100);
    float Menu_Volume = GameSettings.getMenu_Volume();

    int Game_Volume_Value = (int) (GameSettings.getGame_Volume() * 100);
    float Game_Volume = GameSettings.getGame_Volume();

    int Game_SFX_Volume_Value = (int) (GameSettings.getGame_SFX_Volume() * 100);
    float Game_SFX_Volume = GameSettings.getGame_SFX_Volume();

    Texture Title_Banner;
    Texture Background;
    Texture Menu_Background;
    Texture Volume_Button_Not_Selcted;
    Texture Menu_Volume_Button;
    Texture Game_Volume_Button;
    Texture Game_SFX_Volume_Button;
    Texture About_Game;
    Texture New_Game;
    Texture Exit_And_Save;

    Texture About_Game2;
    Texture New_Game2;
    Texture Exit_And_Save2;

    //xture Option_disabled;
    public OptionMenu(SpaceLegends game) {
        this.game = game;

        // platzhalter bilder werden geladen.
        Title_Banner = new Texture("SpaceLegend.png");

        Background = new Texture("background.png");

//        //Menu_Background = new Texture("Menu_background.png");
        Menu_Volume_Button = new Texture("Volume_Buttons/Volume_" + Menu_Volume_Value + ".png");

        Game_Volume_Button = new Texture("Volume_Buttons/Volume_" + Game_Volume_Value + ".png");

        Game_SFX_Volume_Button = new Texture("Volume_Buttons/Volume_" + Game_SFX_Volume_Value + ".png");

        Volume_Button_Not_Selcted = new Texture("Volume_Buttons/Volume_Not_Selected.png");

        About_Game = new Texture("inaktiv.png");

        New_Game = new Texture("inaktiv.png");

        Exit_And_Save = new Texture("inaktiv.png");

        About_Game2 = new Texture("aktiv.png");

        New_Game2 = new Texture("aktiv.png");

        Exit_And_Save2 = new Texture("aktiv.png");

        OptionMenu optionMenu = this;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_DOWN)) && select < 5) {
            select++;
        }
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_UP)) && select > 0) {
            select--;
        }
        
        // Back to the Main Menu with out Save the Settings.
        if(Gdx.input.isKeyJustPressed((Input.Keys.BACKSPACE))){
            game.setScreen(new MainMenu(game));
        }
        
        

        // Set the Menu Volume 
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 0 && Menu_Volume_Value < 100) {
            Menu_Volume += 0.2f;
            Sounds.setMenu_Volume(1f);
            GameSettings.setMenu_Volume(Menu_Volume);
            Menu_Volume_Value = (int) (100 * Menu_Volume);
            setVolume(menuButtonId);

            System.out.println("\nMenue_Volume_Value: " + Menu_Volume_Value + " Menue_Volume: " + Menu_Volume);

        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 0 && Menu_Volume_Value > 0) {
            Menu_Volume_Value -= 20;

            if (Menu_Volume_Value == 0) {
                Menu_Volume = 0f;
            } else {
                Menu_Volume -= 0.2f;
            }

            Sounds.setMenu_Volume(Menu_Volume);
            GameSettings.setMenu_Volume(Menu_Volume);
            setVolume(menuButtonId);

            System.out.println("\nMenu_Volume_Value: " + Menu_Volume_Value + " Menu_Volume: " + Menu_Volume);
        }

        // Set the Game Volume.
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 1 && Game_Volume_Value < 100) {
            Game_Volume += 0.2f;
            Sounds.setGame_Volume(1f);
            GameSettings.setGame_Volume(Game_Volume);
            Game_Volume_Value = (int) (100 * Game_Volume);
            setVolume(gameButtonId);

            System.out.println("\nGame_Volume_Value: " + Game_Volume_Value + " Game_Volume: " + Game_Volume);
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 1 && Game_Volume_Value > 0) {
            Game_Volume_Value -= 20;

            if (Game_Volume_Value == 0) {
                Game_Volume = 0f;
            } else {
                Game_Volume -= 0.2f;
            }
            Sounds.setGame_Volume(Game_Volume);
            GameSettings.setGame_Volume(Game_Volume);

            System.out.println("\nGame_Volume_Value: " + Game_Volume_Value + " Game_Volume: " + Game_Volume);

            setVolume(gameButtonId);
        }

        // Set the Game SFX Volume.
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 2 && Game_SFX_Volume_Value < 100) {
            Game_SFX_Volume += 0.2f;
            Sounds.setGame_SFX_Volume(1f);
            GameSettings.setGame_SFX_Volume(Game_SFX_Volume);
            Game_SFX_Volume_Value = (int) (100 * Game_SFX_Volume);
            setVolume(sfxButtonId);

            System.out.println("\nGame_Volume_Value: " + Game_SFX_Volume_Value + " Game_Volume: " + Game_SFX_Volume);
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 2 && Game_SFX_Volume_Value > 0) {
            Game_SFX_Volume_Value -= 20;

            if (Game_SFX_Volume_Value == 0) {
                Game_SFX_Volume = 0f;
            } else {
                Game_SFX_Volume -= 0.2f;
            }
            Sounds.setGame_SFX_Volume(Game_SFX_Volume);
            GameSettings.setGame_SFX_Volume(Game_SFX_Volume);

            System.out.println("\nGame_SFX_Volume_Value: " + Game_SFX_Volume_Value + " Game_SFX_Volume: " + Game_SFX_Volume);

            setVolume(sfxButtonId);
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        getScreenResoulution();

        game.batch.end();
        com.game.GameSettings.WindowMode.setWindowMode();

    }

    /**
     * Erzeugt die Buttons für das haupt menue und das pause menue
     */
    public void selectMenu() {

        switch (select) {
            case 0:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //  game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                }
                break;
            case 1:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                }
                break;
            case 2:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                    
                }
                break;
            case 3:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game2, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    System.out.println("The Save Game has been Deleted!");
                    Gdx.app.exit();
                }
                break;
            case 4:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game2, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    System.out.println("Über das game");
                    //Gdx.app.exit();                    
                }
                break;
            case 5:
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Background, Background_size_x, Background_size_y);
                //game.batch.draw(Menu_Background, Background_size_y, Background_size_x);
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save2, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    saveGameSettings();
                    System.out.println("Einstelllungen gespeichert.");
                // LoadGameSettings(); // Print the setings to the Terminal
                  game.setScreen(new MainMenu(game));
                   
                } 
                break;

            default:
                break;
        }
    }

    /**
     * Zeichnet die Buttons fuer die Lautstaerke neu.
     *
     * Die zu zeichneden buttons werden mittels der buttonId aus gewaehlt und
     * dann gezeichnet.
     *
     * @param buttonId
     */
    public void setVolume(int buttonId) {
        switch (buttonId) {
            case 0:
                buttonId = 0;
                Menu_Volume_Button = new Texture("Volume_Buttons/Volume_" + Menu_Volume_Value + ".png");

                break;

            case 1:
                buttonId = 1;
                Game_Volume_Button = new Texture("Volume_Buttons/Volume_" + Game_Volume_Value + ".png");
                break;

            case 2:
                buttonId = 2;
                Game_SFX_Volume_Button = new Texture("Volume_Buttons/Volume_" + Game_SFX_Volume_Value + ".png");
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

            // berechnen das die buttons immer in der mitte sind.
            button_Width = button_size_width / 2;
            button_x = screen_width - button_Width + 5;

            button_heigth = button_size_heigth / 2;

        }

        if (Gdx.graphics.getHeight() <= 768) {
            Banner_y = screen_heigth + Banner_heigth - 90;
            button_y = screen_heigth - button_heigth + 2;
            Title_Banner_y = 250;
            Menu_Volume_button_y = 100;
            Game_Volume_button_y = -30;
            About_game_button_y = -160;
            New_Game_y = -200;
            Exit_And_Save_button_y = -250;

            selectMenu();

        } else if (Main_Frame_fullscreen) {
            Banner_y = screen_heigth + Banner_heigth;
            button_y = screen_heigth - button_heigth;

            selectMenu();

        } else {
            Banner_y = screen_heigth + Banner_heigth + 330;
            button_y = screen_heigth - button_heigth + 180;

            selectMenu();
        }

    }

}
