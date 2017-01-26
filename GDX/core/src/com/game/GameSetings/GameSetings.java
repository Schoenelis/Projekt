package com.game.GameSetings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 *
 * @author dreissa
 * @version 0.02
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
public class GameSetings {

    // Einstellungen fuer das Hauptfenster.
    // Versions Verwaltung des Spiels. 
    private static final String build = "      Internal Build Version:";
    private static final String buildnummer = " 00.04";
    private static final String version = " pre-Alpha.";

    // Spiel einstelungen Warnung nicht aendern.
    private static final int Main_Frame_height = 768;
    private static final int Main_Frame_width = 1024;
    public static boolean Main_Frame_fullscreen = true;
    private static final String Main_Frame_IconPath = null; // pfad zum fenster icon.
    private static final String Main_Frame_title = "The Space Legend";
    private static final boolean Main_Frame_resizeble = false;
    
    

    public static void setMain_Frame_fullscreen(boolean Set_fullscreen) {
        Main_Frame_fullscreen = Set_fullscreen;

    }

    public static boolean Main_Frame_isFullscreen() {
        return Main_Frame_fullscreen;
    }

    public static boolean Main_Frame_isResizeble() {
        return Main_Frame_resizeble;
    }

    public static String getRelease() {
        return build + buildnummer + version;
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

}
