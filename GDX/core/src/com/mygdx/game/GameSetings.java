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
    private static final int height = 500;
    private static final int width = 540;
    private static final boolean fullscreen = false;
    private static final String path = null; // pfad zum fenster icon.
    private static final String title = "The Space Legend";
    private static final boolean resizeble = false; 

    
    
    
    
    public static boolean isResizeble() {
        return resizeble;
    }

    public static String getRelease() {
        return build + buildnummer + version;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static boolean isFullscreen() {
        return fullscreen;
    }

    public static String getPath() {
        return path;
    }

    public static String getTitle() {
        return title;
    }
    
    
    
}
