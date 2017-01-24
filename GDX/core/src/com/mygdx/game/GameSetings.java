package com.mygdx.game;

/**
 *
 * @author dreissa
 * @version 0.01
 *
 * Einstelungen fuer den fenster und Volbildmodus Audio usw. .
 *
 * Fenster Groesse angeben und festlegen des blidschirm Modus.
 *
 * height legt die hoehe fest und width legt die breite fest.
 *
 * fullscreen legt fest ob dass spiel im Vollbild modus oder im fenster modus
 * leauft.
 *
 */
public class GameSetings {
     
    // Einstellungen fuer das Hauptfenster.
    
    // Versions Verwaltung des Spiels. 
    private static final String build = "      Internal Build Version:";
    private static final String buildnummer = " 00.001";
    private static final String version =" pre-Alpha.";
            
    // Spiel einstelungen Warnung nicht aendern.
    private static final int Main_Frame_height = 500;
    private static final int Main_Frame_width = 540;
    private static final boolean Main_Frame_fullscreen = false;
    private static final String Main_Frame_IconPath = null; // pfad zum fenster icon.
    private static final String Main_Frame_title = "The Space Legend";
    private static final boolean Main_Frame_resizeble = false; 

    
    
    
    
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

    public static boolean Main_Frame_isFullscreen() {
        return Main_Frame_fullscreen;
    }

    public static String getMain_Frame_IconPath() {
        return Main_Frame_IconPath;
    }

    public static String getMain_Frame_Title() {
        return Main_Frame_title;
    }
    
    
    
}
