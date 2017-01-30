package com.game.GameSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

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
    private static float Menu_Volume = 0.2f;

    // Einstellungen fuer das Hauptfenster.
    // Versions Verwaltung des Spiels. 
    private static final String build = "Internal Build Version:";
    private static final String buildnummer = "00.04";
    private static final String version = "pre-Alpha.";

    // Spiel einstelungen Warnung nicht aendern.
    private static final String Game_Settings_File = "Settings.dat";
    private static final int Main_Frame_height = 768;
    private static final int Main_Frame_width = 1024;
    public static boolean Main_Frame_fullscreen = true;
    private static final String Main_Frame_IconPath = null; // pfad zum fenster icon.
    private static final String Main_Frame_title = "The Space Legend";
    private static final boolean Main_Frame_resizeble = false;

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
     * Returns the Volume of the Menu Music.
     *
     * @return
     */
    public static float getMenu_Volume() {
        return Menu_Volume;
    }

    public static boolean Main_Frame_isFullscreen() {
        return Main_Frame_fullscreen;
    }

    public static boolean Main_Frame_isResizeble() {
        return Main_Frame_resizeble;
    }

    public static String getRelease() {
        return "      " + build + "  " + buildnummer + "  " + version;
    }

    public static int getMain_Frame_Height() {
        return Main_Frame_height;
    }

    public static int getMain_Frame_Width() {
        return Main_Frame_width;
    }

    public static String getMain_Frame_IconPath() {
        return Main_Frame_IconPath;
    }

    public static String getMain_Frame_Title() {
        return Main_Frame_title;
    }

    public static void saveGameSetings() {
//"#Game Settings file do not change this file, it can have side effects for the gameplay and the stability of the game.\n"
//                + "You can change the settings in the Option menu from the Game. :\n\n"
        String data
                = "#Game_Name: " + Main_Frame_title + "\n"
                + "#Bulid_Version: " + build + "  " + buildnummer + "  " + version + "\n"
                + "#Fullscreen: " + Main_Frame_fullscreen + "\n"
                + "#Game_Heigth: " + Main_Frame_height + "\n"
                + "#Game_Width: " + Main_Frame_width + "\n"
                + "#Audio Settings \n"
                + "#Menu Volume: " + Menu_Volume + "\n"
                + "#End:";

        Gdx.files.local(Game_Settings_File).writeString(data, false);

        String readData = Gdx.files.local(Game_Settings_File).readString();
        System.out.println(readData + "\n");

        String temp = "Noch leer";
        char cut = ':';
        char cut2 = '\n';
        int index = 0;
        int ab = 11;
        int bis = 28;

        if (readData == null) {
            System.out.println("Load default setings");
        }

        int laenge = readData.length() - 1;

        while (index <= laenge) {

//            // Nach dem Trennzeichen cut suchen.
//            if (readData.charAt(index) == cut) {
//                index++;
//                ab = index;
//
//                // alles zahlen bis cut2 auftaucht.
//                while (readData.charAt(index) != cut2) {
//                    index++;
//                    bis = index;
//                }
//
//            }else{
//                index++;
//            }
//
    }

        //als letztel redData zerschneiden.
        temp = readData.substring(ab, bis);

        System.out.println(temp);

    }

}
