/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameSetings;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author Dreissa
 * @version 0.1
 *
 * Erstellt das Hauptfenster.
 *
 */
public class MainFrame {

    public static void MainFrame() {
        LwjglApplicationConfiguration mainframe = new LwjglApplicationConfiguration();

        // Titel und icon wird festgelegt.
        mainframe.title = GameSetings.getMain_Frame_Title() + GameSetings.getRelease() + "  " + mainframe.foregroundFPS + "  FPS";
        //config.addIcon(path, Files.FileType.Internal);

        // Fenster Groesse anpassen.
        mainframe.height = GameSetings.getMain_Frame_Height();
        mainframe.width = GameSetings.getMain_Frame_Width();
        mainframe.resizable = GameSetings.Main_Frame_isResizeble();

        // vollbild ein oder aus schalten.
        if (GameSetings.Main_Frame_isFullscreen()) {
            mainframe.fullscreen = GameSetings.Main_Frame_isFullscreen();
            mainframe.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
            mainframe.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;

        } else {
            mainframe.fullscreen = GameSetings.Main_Frame_isFullscreen();
        }

        LwjglApplication lwjglApplication = new LwjglApplication(new MyGdxGame(), mainframe);

    }
}
