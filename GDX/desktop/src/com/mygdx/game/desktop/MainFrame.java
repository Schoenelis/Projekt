
package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.GameSettings.GameSettings;
import com.mygdx.game.SpaceLegends;

/**
 * Stellt das hauptfenster ein und startet das spiel.
 * @author Dreissa
 */
 
public class MainFrame {

    public static void MainFrame() {
        LwjglApplicationConfiguration mainframe = new LwjglApplicationConfiguration();

        // Titel und icon wird festgelegt.
       mainframe.title = GameSettings.getMain_Frame_Title() + GameSettings.getRelease();
        //config.addIcon(path, Files.FileType.Internal);

        // Fenster Groesse anpassen.
        mainframe.height = GameSettings.getMain_Frame_Height();
        mainframe.width = GameSettings.getMain_Frame_Width();
        mainframe.resizable = GameSettings.Main_Frame_isResizeble();

        // vollbild ein oder aus schalten.
        if (GameSettings.Main_Frame_isFullscreen()) {
            
            mainframe.fullscreen = GameSettings.Main_Frame_isFullscreen();
            mainframe.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
            mainframe.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
                    
        } else {
            mainframe.fullscreen = GameSettings.Main_Frame_isFullscreen();
        }

        LwjglApplication lwjglApplication = new LwjglApplication(new SpaceLegends(), mainframe);

    }
}
