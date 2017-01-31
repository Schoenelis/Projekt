package com.game.GameSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import javax.swing.JOptionPane;

/**
 *
 * @author dreissa
 * @version 0.03
 *
 * Einstelungen fuer den fenster und Volbildmodus Audio usw. .
 *
 * Folgende beispiele sind moeglich:
 *
 * Fenster Groesse angeben und festlegen des blidschirm Modus.
 *
 * Festlegen ob dass spiel im Vollbild modus oder im Fenstermodus leauft.
 *
 * Die Version und den Titel des Spiels ausgeben.
 *
 */
public class GameSettings {

    //Spiel Einstelungen eigestelt durch den Spieler.
    //Anlegen der Lautstearke der Audiodatein.
    private static float Menu_Volume = 0.0f;
    private static float Button_Volume = 0.0f;
    private static float Game_Volume = 0.0f;
    private static float Game_SFX_Volume = 0.0f; 
   
    // Einstellungen fuer das Hauptfenster.
    // Versions Verwaltung des Spiels. 
    private static final String build = "Internal Build Version";
    private static final String buildnummer = "00.04";
    private static final String version = "pre-Alpha.";

    // Spiel einstelungen Warnung nicht aendern.
    public static final String Game_Settings_File = "Settings.dat";
    private static final int Main_Frame_height = 768;
    private static final int Main_Frame_width = 1024;
    public static boolean Main_Frame_fullscreen = true;
    private static final String Main_Frame_IconPath = null; // pfad zum fenster icon.
    private static final String Main_Frame_title = "The Space Legend";
    private static final boolean Main_Frame_resizeble = false;

    /**
     * Set the Game to Fullscreen in the final game this has no effects.
     *
     * @param Set_fullscreen
     */
    public static void setMain_Frame_fullscreen(boolean Set_fullscreen) {
        Main_Frame_fullscreen = Set_fullscreen;

    }

    /**
     * Set the Volume of the Menu Music.
     *
     * @param Menu_Volume
     */
    public static void setMenu_Volume(float Menu_Volume) {
        GameSettings.Menu_Volume = Menu_Volume;
    }

    /**
     * Set the Volume of the Game Music
     *
     * @param Game_Volume
     */
    public static void setGame_Volume(float Game_Volume) {
        GameSettings.Game_Volume = Game_Volume;
    }

    /**
     * Returns the Volume of the game Buttons.
     *
     * @return
     */
    public static float getButton_Volume() {
        return Button_Volume;
    }

    /**
     * Returns the Volume of the Game.
     *
     * @return
     */
    public static float getGame_Volume() {
        return Game_Volume;
    }

    /**
     * Returns the Volume of the special effects in the Game.
     *
     * @return
     */
    public static float getGame_SFX_Volume() {
        return Game_SFX_Volume;
    }

    /**
     * Returns the name of the Game_Settings_File.
     *
     * @return
     */
    public static String getGame_Settings_File() {
        return Game_Settings_File;
    }

    /**
     * Returns the Volume of the Menu Music.
     *
     * @return
     */
    public static float getMenu_Volume() {
        return Menu_Volume;
    }

    /**
     * Returns if the game Fullscreen or not in the final game you can only use
     * Fullscreen.
     *
     * @return
     */
    public static boolean Main_Frame_isFullscreen() {
        return Main_Frame_fullscreen;
    }

    /**
     * Returns if the Game is Resizeble
     *
     * @return
     */
    public static boolean Main_Frame_isResizeble() {
        return Main_Frame_resizeble;
    }

    /**
     * Returns the Release of the Game.
     *
     * @return
     */
    public static String getRelease() {
        return "      " + build + "  " + buildnummer + "  " + version;
    }

    /**
     * Returns the Heigth of the Game.
     *
     * @return
     */
    public static int getMain_Frame_Height() {
        return Main_Frame_height;
    }

    /**
     * Returns the Width of the Game.
     *
     * @return
     */
    public static int getMain_Frame_Width() {
        return Main_Frame_width;
    }

    /**
     * Returns the ichon of the Game.
     *
     * @return
     */
    public static String getMain_Frame_IconPath() {
        return Main_Frame_IconPath;
    }

    /**
     * Returns the title of the Game
     *
     * @return
     */
    public static String getMain_Frame_Title() {
        return Main_Frame_title;
    }

    public static void setGame_SFX_Volume(float Game_SFX_Volume) {
        GameSettings.Game_SFX_Volume = Game_SFX_Volume;
    }

    public static void saveGameSettings() {

        String data = "#Game Settings file do not change this file, it can have side effects for the gameplay and the stability of the game.\n"
                + "You can change the settings in the Option menu from the Game.\n\n"
                + "#Audio Settings \n"
                + "#Menu Volume: " + Menu_Volume + ",\n"
                + "#Buton_Volume: " + Button_Volume + ",\n"
                + "#Game_Volume: " + Game_Volume + ",\n"
                + "#FX_Volume: " + Game_SFX_Volume + ",\n"
                + "#End";

        Gdx.files.local(Game_Settings_File).writeString(data, false);

    }

    /**
     * Die spiel einstelungen werden geladen.
     *
     * @return
     */
    public static Boolean LoadGameSettings() {

        //Set the Char for the String Cuting
        final char cut = ':';
        final char cut2 = ',';

        boolean DATA_LOAD_OK = false;
        final int arrayLength = 5;
        String DATA_READ = null;
        int index = 0;
        int beginIndex = 0;
        int endIndex = 0;
        int SetingsCount = 0;
        int String_Size = 0;

        // String Array for the output settings.
        String[] SETTINGS_DATA = new String[arrayLength];

        //Loading the curent Game Setings from the Setings File.
        
        try {
            DATA_READ = Gdx.files.local(Game_Settings_File).readString();
        } catch (Exception e) {
            System.err.println("\n Fehler datei wurde nicht Gefunden" + e);
            System.out.println("Loading default setings");
            return DATA_LOAD_OK;            
       }

        if (DATA_READ == null || DATA_READ.isEmpty()) {

            System.out.println("Load default setings");
            //return DATA_LOAD_OK;

            // saveGameSettings();
        } else {

            System.out.println("\nReading SetingsData: \n" + DATA_READ + "\n");

            String_Size = DATA_READ.length() - 1;

            while (index <= String_Size) {

                // Search for cut in the String and set the beginIndex.
                if (index < String_Size && DATA_READ.charAt(index) == cut) {
                    index++;
                    beginIndex = index + 1;

                    // Search for cut2 in the String and set the endIndex.
                    while (index < String_Size && DATA_READ.charAt(index) != cut2) {
                        index++;
                    }
                    SetingsCount++;
                    endIndex = index;
                } else {

                    index++;
                }
                //Cut DATA_READ            
                SETTINGS_DATA[SetingsCount] = DATA_READ.substring(beginIndex, endIndex);

            }

            // Set the Values.  
            Menu_Volume = Float.parseFloat(SETTINGS_DATA[1]);
            Button_Volume = Float.parseFloat(SETTINGS_DATA[2]);
            Game_Volume = Float.parseFloat(SETTINGS_DATA[3]);
            Game_SFX_Volume = Float.parseFloat(SETTINGS_DATA[4]);

            DATA_LOAD_OK = true;

            //Print the Value to the Terminal for Testing.
            for (int i = 0; i < SETTINGS_DATA.length; i++) {
                System.out.println(SETTINGS_DATA[i]);
            }
        }
        return DATA_LOAD_OK;

    }

    public static void LoadDefaultSettings() {
        Menu_Volume = 1f;
        Button_Volume = 0.6f;
        Game_Volume =1f;
        Game_SFX_Volume = 0.6f;
    }

}
