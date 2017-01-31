package com.mygdx.game.desktop;

import com.game.GameSettings.GameSettings;
import java.awt.Component;
import javax.swing.JOptionPane;

public class DesktopLauncher {

    /**
     * Erzeugt die Fenster und startet die anwendung.
     *
     * @param arg
     */
    public static void main(String[] arg) {

        MainFrame.MainFrame();

      loadsettings();

    }

    public static void loadsettings() {

        Component MainFrame = null;

     

        if (!GameSettings.LoadGameSettings()) {
            JOptionPane.showMessageDialog(MainFrame, "An error occurred while loading the Game settings. \n"
                    + "Click on Ok to load the default Settings.", "Settings Error", JOptionPane.ERROR_MESSAGE);
            GameSettings.LoadDefaultSettings();
        }

    }
}
