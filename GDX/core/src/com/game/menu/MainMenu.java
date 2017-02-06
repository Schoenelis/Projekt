package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.game.Audio.Sounds;
import static com.game.GameSettings.GameSettings.*;
import com.mygdx.game.SpaceLegends;
import java.io.IOException;

public class MainMenu implements Screen {

    // Groesse der schaltflaechen.
    private static int buton_size_heigth;// = 90;
    private static int buton_size_width;// = 400;

    private static int Title_banner_size_heigth;// = 400;
    private static int Title_Banner_size_width;// = 1200;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    // position der schaltflaeche und des Banners.

    // y positionen der bilder.1
    private static int Title_Banner_y = Gdx.graphics.getHeight() -250; 
    private static int Start_button_y = Title_Banner_y /2 -150;
    private static int Option_button_y = Start_button_y - 150;
    private static int Exit_button_y = Option_button_y -150;

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

    Texture Background;
    Texture Low_Resoulution;
    Texture Title_Banner;
    Texture Start_enabled;
    Texture Exit_enabled;
    Texture Option_enabled;
    Texture Start_disabled;
    Texture Exit_disabled;
    Texture Option_disabled;
    Texture Load_Default_Settings;

//    boolean LoadGameSettings = LoadGameSettings(); ("Game_Grafiken/background.png");
    public MainMenu(SpaceLegends game) {
        this.game = game;
        LoadGameSettings();
        MainMenu mainMenuScreen = this;
    }

    @Override
    public void show() {
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            Background = new Texture(root.getChildByName("background").getAttribute("texture"));
            Load_Default_Settings = new Texture(root.getChildByName("loaddefaultsettings").getAttribute("texture"));
            Low_Resoulution = new Texture(root.getChildByName("lowresoulution").getAttribute("texture"));
            Element title = root.getChildByName("title");
            Title_banner_size_heigth = Integer.parseInt(title.getAttribute("heigth"));
            Title_Banner_size_width = Integer.parseInt(title.getAttribute("width"));
            //  Title_Banner_y = Integer.parseInt(title.getAttribute("y"));
            Title_Banner = new Texture(title.getAttribute("texture"));

            // Loading the Menu Elements from the xml file.
            Element menu = root.getChildByName("mainmenue");
            buton_size_heigth = Integer.parseInt(menu.getAttribute("heigth"));
            buton_size_width = Integer.parseInt(menu.getAttribute("width"));

            Start_enabled = new Texture(menu.getChildByName("playbutton").getAttribute("texture_enabled"));
//            Start_button_y = Integer.parseInt(menu.getChildByName("playbutton").getAttribute("y"));
            Option_enabled = new Texture(menu.getChildByName("optionbutton").getAttribute("texture_enabled"));
//            Option_button_y = Integer.parseInt(menu.getChildByName("optionbutton").getAttribute("y"));
            Exit_enabled = new Texture(menu.getChildByName("exitbutton").getAttribute("texture_enabled"));
//            Exit_button_y = Integer.parseInt(menu.getChildByName("exitbutton").getAttribute("y"));

            Start_disabled = new Texture(menu.getChildByName("playbutton").getAttribute("texture_disabled"));
            Option_disabled = new Texture(menu.getChildByName("optionbutton").getAttribute("texture_disabled"));
            Exit_disabled = new Texture(menu.getChildByName("exitbutton").getAttribute("texture_disabled"));
        } catch (IOException ex) {
            System.err.print(ex);
        }

    }

    @Override
    public void render(float delta) {

        // Check if Game Settings ok.
        if (DATA_LOAD_Fail) {
            select = -99;
        } else {
            //Listen to the keybord and wait for a user input 
            if (Gdx.input.isKeyJustPressed((Keys.DPAD_DOWN)) && select < 3) {
                Sounds.playButtonSound();   // Playing sound when a button is Selected.
                select++;
            } else if (select == 3) { //make a Selecting loop .
                select = 0;
            }

            if (Gdx.input.isKeyJustPressed((Keys.DPAD_UP)) && select > -1) {
                Sounds.playButtonSound();
                select--;
            } else if (select == -1) {
                select = 2;
            }
        }
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(Background, Background_size_x, Background_size_y);
        game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
        getScreenResoulution();
        game.batch.end();
        com.game.GameSettings.WindowMode.setWindowMode();
    }

    /**
     * Generates the Butons for the main menu the LoadDefaultSettings dialog and
     * draws the titel and the Background of the menu.
     */
    public void selectMenu() {

        switch (select) {
            // Case -99 Draws the  LoadDefaultSettings Dialog.
            case -99:
                game.batch.draw(Background, Background_size_x, Background_size_y);
                game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
                game.batch.draw(Load_Default_Settings, buton_x, buton_y + Option_button_y, 100, 100);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    LoadDefaultSettings();
                    saveGameSettings();
                    DATA_LOAD_Fail = false;// set  DATA_LOAD_Fail to false and returns to the main menu.
                    game.setScreen(new MainMenu(game));
                }
                break;
            case 0:
                game.batch.draw(Start_enabled, buton_x, buton_y + Start_button_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_disabled, buton_x, buton_y + Option_button_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_disabled, buton_x, buton_y + Exit_button_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    Sounds.playGameSound();
                    game.setScreen(new MyGdxGame(game));
                }
                break;
            case 1:
                game.batch.draw(Start_disabled, buton_x, buton_y + Start_button_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_enabled, buton_x, buton_y + Option_button_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_disabled, buton_x, buton_y + Exit_button_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    game.setScreen(new OptionMenu(game));
                }
                break;
            case 2:
                game.batch.draw(Start_disabled, buton_x, buton_y + Start_button_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Option_disabled, buton_x, buton_y + Option_button_y, buton_size_width, buton_size_heigth);
                game.batch.draw(Exit_enabled, buton_x, buton_y + Exit_button_y, buton_size_width, buton_size_heigth);
                if (Gdx.input.isKeyJustPressed((Keys.ENTER))) {
                    Gdx.app.exit();
                }
                break;

            default:
                break;
        }
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

//            buton_size_heigth = 80;
//            buton_size_width = 250;
//
//            //      Title_Banner_y = 250;
//          //  Start_button_y = 100;
//          //  Option_button_y = -30;
//          //  Exit_button_y = -160;
//
           selectMenu();
//
        } else if (Main_Frame_fullscreen) {
            Banner_y = screen_heigth + Banner_heigth + 50;
            buton_y = screen_heigth - buton_heigth + 50;

            selectMenu();

//        } else {
//            Banner_y = screen_heigth + Banner_heigth + 330;
//            buton_y = screen_heigth - buton_heigth + 180;
//
//            selectMenu();
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
