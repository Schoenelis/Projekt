package com.mygdx.game;

import com.game.Audio.Sounds;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import static com.game.GameSettings.GameSettings.*;
import com.game.menu.MainMenu;
import com.game.menu.OptionMenu;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Hauptklasse des spiels.
 *
 * @author dreissa
 * @version 0.01
 */
public class SpaceLegends extends Game {

    Sounds sound;
    public SpriteBatch batch;
    private String setScreen;

    @Override
    public void create() {


        if (!LoadGameSettings()) {
            System.out.println("Loading Setting file Failed ");

         JOptionPane.showMessageDialog(null, "An error occurred while loading the Game settings. \n"
          + "Click on Ok to load the default Settings.", "Settings Error", JOptionPane.ERROR_MESSAGE);
         
         
           
            
            sound = new Sounds();
            batch = new SpriteBatch();
            this.setScreen(new MainMenu(this));
            
        } else {
            
            LoadGameSettings();
            sound = new Sounds();
            batch = new SpriteBatch();

            this.setScreen(new MainMenu(this));
            //this.setScreen(new OptionMenu(this));
        }
    }
    

    public SpaceLegends() {
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

}
