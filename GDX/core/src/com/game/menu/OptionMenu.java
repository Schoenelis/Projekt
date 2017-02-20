package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.game.Audio.Sounds;
import com.game.GameSettings.GameSettings;
import static com.game.GameSettings.GameSettings.Main_Frame_fullscreen;
import static com.game.GameSettings.GameSettings.*;
import com.mygdx.game.SpaceLegends;
import java.io.IOException;

/**
 * Creates the Option Menu
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
    private int button_size_heigth;// = 80;
    private int button_size_width;// = 230;

//    private final int Menu_Background_heigth = 100;
//    private final int Menu_Background_width = Gdx.graphics.getWidth();
    private int Menuetext_heigth;// = 120;
    private int Menuetext_width;// = 550;

    private static int Title_banner_size_heigth;//= 400;
    private int Title_Banner_size_width;//= 1200;

    private final float Background_size_x = (float) (Gdx.graphics.getWidth() * 0.0);
    private final float Background_size_y = (float) (Gdx.graphics.getHeight() * 0.0);
    // position der schaltflaeche und des Banners.

    // y positionen der bilder.
    private static int Title_Banner_y2 = Gdx.graphics.getHeight() - 250; // 200;
    private static int Title_Banner_y = Gdx.graphics.getHeight() + Title_banner_size_heigth - 200; // 200;
    private int Menu_Volume_button_y = Title_Banner_y2 / 2 - 150;//250;
    private int Game_Volume_button_y = Menu_Volume_button_y - 100; //150;
    private int Game_SFX_Volume_button_y = Game_Volume_button_y - 100;// 50;
    private int About_game_button_y = Game_SFX_Volume_button_y - 100;//-50;
    private int New_Game_y = About_game_button_y - 100;// -150;
    private int Exit_And_Save_button_y = New_Game_y - 100;//-250;

    //
    private int button_Width = 0;
    private int button_heigth = 0;
//    private int MBackground_Width = 0;
//    private int MBackground_heigt = 0;

    private int Banner_Width = 0;
    private int Banner_heigth = 0;

    private int Banner_x = 0;
    private int Banner_y = 0;
    private int button_x = 0;
    private int button_y = 0;
//    private int Menu_Background_x = 0;
//    private int Menu_Background_y = 0;
////
    private int Menuetext0_y = Title_Banner_y2 - 30;//Menu_Volume_button_y;
    private int Menuetext1_y = Menuetext0_y - 100;//Menu_Volume_button_y;//Menuetext0_y - 160;
    private int Menuetext2_y = Menuetext1_y - 100;//Game_Volume_button_y +100;//Menu_Volume_button_y - 100;//
    private int Menuetext3_y = Menuetext2_y - 100;//Game_SFX_Volume_button_y+30;//Game_Volume_button_y - 100;// 
    private int Menuetext4_y = Menuetext3_y - 100;//About_game_button_y+30;//Game_SFX_Volume_button_y - 100;//
    private int Menuetext5_y = Menuetext4_y - 100;//Exit_And_Save_button_y-30;//About_game_button_y - 100;// 

    private int Menuetext_x = 0;

    private int screen_width = 0;
    private int screen_heigth = 0;

    private String path;

    int Menu_Volume_Value = (int) (GameSettings.getMenu_Volume() * 100);
    float Menu_Volume = GameSettings.getMenu_Volume();

    int Game_Volume_Value = (int) (GameSettings.getGame_Volume() * 100);
    float Game_Volume = GameSettings.getGame_Volume();

    int Game_SFX_Volume_Value = (int) (GameSettings.getGame_SFX_Volume() * 100);
    float Game_SFX_Volume = GameSettings.getGame_SFX_Volume();

    Texture Menuetext0;
    Texture Menuetext1;
    Texture Menuetext2;
    Texture Menuetext3;
    Texture Menuetext4;
    Texture Menuetext5;

    Texture Title_Banner;
    Texture Background;
    Texture Menu_Background;
    Texture Volume_Button_Not_Selcted;
    Texture Menu_Volume_Button;
    Texture Game_Volume_Button;
    Texture Game_SFX_Volume_Button;
    Texture About_Game_enabled;
    Texture New_Game_enabled;
    Texture Exit_And_Save_enabled;

    Texture About_Game_disabled;
    Texture New_Game_disabled;
    Texture Exit_And_Save_disabled;

    private static Element optionmenu;

    //xture Option_disabled;
    public OptionMenu(SpaceLegends game) {
        this.game = game;
        OptionMenu optionMenu = this;
    }

    @Override
    public void show() {
        System.out.println("breite:" + Gdx.graphics.getWidth() + " höhe: " + Gdx.graphics.getHeight());
        try {
            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            Background = new Texture(root.getChildByName("background").getAttribute("texture"));
            Element title = root.getChildByName("title");
            Title_Banner = new Texture(title.getAttribute("optionmenutitle"));

            Title_banner_size_heigth = Integer.parseInt(title.getAttribute("heigth"));

            Title_Banner_size_width = Integer.parseInt(title.getAttribute("width"));
            //  Title_Banner_y = Integer.parseInt(title.getAttribute("y"));

            // Loading the Menu Elements from the xml file.
            Element menu = root.getChildByName("optionmenu");
            button_size_heigth = Integer.parseInt(menu.getAttribute("heigth"));
            button_size_width = Integer.parseInt(menu.getAttribute("width"));
            // Loading the Optionmenu Buttons.
            optionmenu = root.getChildByName("optionmenu");
            Menu_Background = new Texture(optionmenu.getChildByName("background").getAttribute("texture"));

            Menuetext_heigth = Integer.parseInt(optionmenu.getChildByName("menutext").getAttribute("menuetextheigth"));
            Menuetext_width = Integer.parseInt(optionmenu.getChildByName("menutext").getAttribute("menuetextwidth"));

            Menuetext0 = new Texture(optionmenu.getChildByName("menutext").getAttribute("menuetext0"));
            Menuetext1 = new Texture(optionmenu.getChildByName("menutext").getAttribute("menuetext1"));
            Menuetext2 = new Texture(optionmenu.getChildByName("menutext").getAttribute("menuetext2"));
            Menuetext3 = new Texture(optionmenu.getChildByName("menutext").getAttribute("menuetext3"));
            Menuetext4 = new Texture(optionmenu.getChildByName("menutext").getAttribute("menuetext4"));
            Menuetext5 = new Texture(optionmenu.getChildByName("menutext").getAttribute("menuetext5"));

            Menu_Volume_Button = new Texture(optionmenu.getChildByName("volumebuttons").getAttribute("volumetexture" + Menu_Volume_Value));
            Game_Volume_Button = new Texture(optionmenu.getChildByName("volumebuttons").getAttribute("volumetexture" + Game_Volume_Value));
            Game_SFX_Volume_Button = new Texture(optionmenu.getChildByName("volumebuttons").getAttribute("volumetexture" + Game_SFX_Volume_Value));

            Volume_Button_Not_Selcted = new Texture(optionmenu.getChildByName("volumebuttonnotselcted").getAttribute("texture"));
            About_Game_enabled = new Texture(optionmenu.getChildByName("aboutgame").getAttribute("texture_enabled"));
            New_Game_enabled = new Texture(optionmenu.getChildByName("newgame").getAttribute("texture_enabled"));
            Exit_And_Save_enabled = new Texture(optionmenu.getChildByName("exitandsave").getAttribute("texture_enabled"));
            About_Game_disabled = new Texture(optionmenu.getChildByName("aboutgame").getAttribute("texture_disabled"));
            New_Game_disabled = new Texture(optionmenu.getChildByName("newgame").getAttribute("texture_disabled"));
            Exit_And_Save_disabled = new Texture(optionmenu.getChildByName("exitandsave").getAttribute("texture_disabled"));

        } catch (IOException ex) {
            System.err.print(ex);
        }

    }

    @Override
    public void render(float delta) {

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_DOWN)) && select < 5) {
            if (select < 2) {
                Sounds.stopSound(Sounds.Menu_Music);
                Sounds.stopSound(Sounds.Game_Music);
                Sounds.stopSound(Sounds.Game_SFX_Sound);
            }
            Sounds.playButtonSound();
            Sounds.stopSound(Sounds.Menu_Music);
            Sounds.stopSound(Sounds.Game_Music);
            Sounds.stopSound(Sounds.Game_SFX_Sound);;

            select++;
        }
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_UP)) && select > 0) {
            if (select > 0) {
                Sounds.stopSound(Sounds.Menu_Music);
                Sounds.gameEnd();
                Sounds.stopSound(Sounds.Game_SFX_Sound);

            }
            Sounds.playButtonSound();
            Sounds.stopSound(Sounds.Menu_Music);
            Sounds.gameEnd();
            Sounds.stopSound(Sounds.Game_SFX_Sound);

            select--;
        }

        // Back to the Main Menu with out Save the Settings.
        if (Gdx.input.isKeyJustPressed((Input.Keys.BACKSPACE))) {
            game.setScreen(new MainMenu(game));
        }

        // Set the Menu Volume 
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 0 && Menu_Volume_Value < 100) {
            Menu_Volume += 0.2f;

            Sounds.setMenu_Volume(1f);
            Sounds.setMenu_Volume(Menu_Volume);
            GameSettings.setMenu_Volume(Menu_Volume);
            Menu_Volume_Value = (int) (100 * Menu_Volume);
            setVolume(menuButtonId);

            System.out.println("\nMenue_Volume_Value: " + Menu_Volume_Value + " Menue_Volume: " + Menu_Volume);
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 0 && Menu_Volume_Value > 0) {
            Menu_Volume_Value -= 20;

            if (Menu_Volume_Value == 0) {
                Menu_Volume = 0f;// Set the Volume to 0
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
            Sounds.setGame_Volume(Game_Volume);
            GameSettings.setGame_Volume(Game_Volume);
            Game_Volume_Value = (int) (100 * Game_Volume);
            setVolume(gameButtonId);

            System.out.println("\nGame_Volume_Value: " + Game_Volume_Value + " Game_Volume: " + Game_Volume);
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 1 && Game_Volume_Value > 0) {
            Game_Volume_Value -= 20;

            if (Game_Volume_Value == 0) {
                Game_Volume = 0f;// Set the Volume to 0
            } else {
                Game_Volume -= 0.2f;
            }

            Sounds.setGame_Volume(Game_Volume);
            GameSettings.setGame_Volume(Game_Volume);
            setVolume(gameButtonId);
            System.out.println("\nGame_Volume_Value: " + Game_Volume_Value + " Game_Volume: " + Game_Volume);
        }

        // Set the Game SFX Volume.
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_RIGHT)) && select == 2 && Game_SFX_Volume_Value < 100) {
            Game_SFX_Volume += 0.2f;

            Sounds.setGame_SFX_Volume(1f);
            Sounds.setGame_SFX_Volume(Game_SFX_Volume);
            GameSettings.setGame_SFX_Volume(Game_SFX_Volume);
            Game_SFX_Volume_Value = (int) (100 * Game_SFX_Volume);
            setVolume(sfxButtonId);

            System.out.println("\nGame_Volume_Value: " + Game_SFX_Volume_Value + " Game_Volume: " + Game_SFX_Volume);
        }

        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_LEFT)) && select == 2 && Game_SFX_Volume_Value > 0) {
            Game_SFX_Volume_Value -= 20;

            if (Game_SFX_Volume_Value == 0) {
                Game_SFX_Volume = 0f;// Set the Volume to 0
            } else {
                Game_SFX_Volume -= 0.2f;
            }

            Sounds.setGame_SFX_Volume(Game_SFX_Volume);
            GameSettings.setGame_SFX_Volume(Game_SFX_Volume);
            setVolume(sfxButtonId);
            System.out.println("\nGame_SFX_Volume_Value: " + Game_SFX_Volume_Value + " Game_SFX_Volume: " + Game_SFX_Volume);
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(Background, Background_size_x, Background_size_y);
        game.batch.draw(Title_Banner, Banner_x, Banner_y, Title_Banner_size_width, Title_banner_size_heigth);
        game.batch.draw(Menuetext5, Menuetext_x, Menuetext5_y, Menuetext_width, Menuetext_heigth);
        game.batch.draw(Menuetext4, Menuetext_x, Menuetext4_y, Menuetext_width, Menuetext_heigth);
        game.batch.draw(Menuetext3, Menuetext_x, Menuetext3_y, Menuetext_width, Menuetext_heigth);
        game.batch.draw(Menuetext2, Menuetext_x, Menuetext2_y, Menuetext_width, Menuetext_heigth);
        game.batch.draw(Menuetext1, Menuetext_x, Menuetext1_y, Menuetext_width, Menuetext_heigth);
        game.batch.draw(Menuetext0, Menuetext_x, Menuetext0_y, Menuetext_width, Menuetext_heigth);

//        game.batch.draw(Menu_Background, 0, 0, Menu_Background_width, Menu_Background_heigth);
        game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
        game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
        game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
        game.batch.draw(About_Game_disabled, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);
        game.batch.draw(New_Game_disabled, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
        game.batch.draw(Exit_And_Save_disabled, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);

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
                game.batch.draw(Menu_Volume_Button, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                }
                break;
            case 1:
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_Volume_Button, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();
                }
                break;
            case 2:
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Game_SFX_Volume_Button, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    //Gdx.app.exit();

                }
                break;
            case 3:
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(About_Game_enabled, button_x, button_y + About_game_button_y, button_size_width, button_size_heigth);

                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    System.out.println("The Save Game has been Deleted!");
                    //Gdx.app.exit();
                }
                break;
            case 4:
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(New_Game_enabled, button_x, button_y + New_Game_y, button_size_width, button_size_heigth);
                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    System.out.println("Über das game");
                    //Gdx.app.exit();                    
                }
                break;
            case 5:
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Menu_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Volume_Button_Not_Selcted, button_x, button_y + Game_SFX_Volume_button_y, button_size_width, button_size_heigth);
                game.batch.draw(Exit_And_Save_enabled, button_x, button_y + Exit_And_Save_button_y, button_size_width, button_size_heigth);
                if (Gdx.input.isKeyJustPressed((Input.Keys.ENTER))) {
                    saveGameSettings();
                    System.out.println("Einstelllungen gespeichert.");
                    // LoadGameSettings(); // Print the setings to the Terminal

                    Sounds.playMenuSound();
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
     * @param buttonId id
     */
    public void setVolume(int buttonId) {
        switch (buttonId) {
            case 0:
                buttonId = 0;
                Menu_Volume_Button = new Texture(optionmenu.getChildByName("volumebuttons").getAttribute("volumetexture" + Menu_Volume_Value));
                break;
            case 1:
                buttonId = 1;
                Game_Volume_Button = new Texture(optionmenu.getChildByName("volumebuttons").getAttribute("volumetexture" + Game_Volume_Value));
                break;
            case 2:
                buttonId = 2;
                Game_SFX_Volume_Button = new Texture(optionmenu.getChildByName("volumebuttons").getAttribute("volumetexture" + Game_SFX_Volume_Value));
                break;
        }
    }

    @Override
    public void resize(int width, int height
    ) {
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
            Menuetext_x = button_x - 570;
            button_heigth = button_size_heigth / 2;

        }

        if (Gdx.graphics.getHeight() <= 768) {
            Banner_y = screen_heigth + Banner_heigth - 90;
            button_y = screen_heigth - button_heigth + 2;
//            Title_Banner_y = 50;
//            Menu_Volume_button_y = 250;
//            Game_Volume_button_y = 150;
//            Game_SFX_Volume_button_y = 50;
//            About_game_button_y = -50;
//            New_Game_y = -150;
//            Exit_And_Save_button_y = -250;

            Title_Banner_y = Gdx.graphics.getHeight() - 250; // 200;
            Menu_Volume_button_y = Title_Banner_y / 2 - 80;//250;
            Game_Volume_button_y = Menu_Volume_button_y - 100; //150;
            Game_SFX_Volume_button_y = Game_Volume_button_y - 100;// 50;
            About_game_button_y = Game_SFX_Volume_button_y - 100;//-50;
            New_Game_y = About_game_button_y - 100;// -150;
            Exit_And_Save_button_y = New_Game_y - 100;//-250;

            Menuetext0_y = Title_Banner_y - 20;
            Menuetext1_y = Menuetext0_y - 90;
            Menuetext2_y = Menuetext1_y - 90;
            Menuetext3_y = Menuetext2_y - 100;
            Menuetext4_y = Menuetext3_y - 100;
            Menuetext5_y = Menuetext4_y - 100;

            selectMenu();
        } else if (Gdx.graphics.getHeight() <= 900) {
            Banner_y = screen_heigth + Banner_heigth;
            button_y = screen_heigth - button_heigth;

            Title_Banner_y = Gdx.graphics.getHeight() - 250; // 200;
            Menu_Volume_button_y = Title_Banner_y / 2 - 80;//250;
            Game_Volume_button_y = Menu_Volume_button_y - 100; //150;
            Game_SFX_Volume_button_y = Game_Volume_button_y - 100;// 50;
            About_game_button_y = Game_SFX_Volume_button_y - 100;//-50;
            New_Game_y = About_game_button_y - 100;// -150;
            Exit_And_Save_button_y = New_Game_y - 100;//-250;

            Menuetext0_y = Title_Banner_y - 20;
            Menuetext1_y = Menuetext0_y - 90;
            Menuetext2_y = Menuetext1_y - 90;
            Menuetext3_y = Menuetext2_y - 100;
            Menuetext4_y = Menuetext3_y - 100;
            Menuetext5_y = Menuetext4_y - 100;

            selectMenu();
        } else if (Main_Frame_fullscreen) {
            Banner_y = screen_heigth + Banner_heigth + 60;
            button_y = screen_heigth - button_heigth + 50;

            selectMenu();

//        } else {
//            Banner_y = screen_heigth + Banner_heigth + 330;
//            button_y = screen_heigth - button_heigth + 180;
//
//            selectMenu();
        }

    }

}
