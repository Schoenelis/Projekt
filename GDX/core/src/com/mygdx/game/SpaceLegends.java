package com.mygdx.game;

import com.game.Audio.Sounds;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.menu.MainMenu;

/**
 * Hauptklasse des spiels.
 *
 * @author dreissa
 * @version 0.01
 */
public class SpaceLegends extends Game {

    Sounds sound;
    public SpriteBatch batch;
   
    @Override
    public void create() {
            SpaceLegends();    
    }

    public void SpaceLegends() {
        sound = new Sounds();
        batch = new SpriteBatch();
         
        this.setScreen(new MainMenu(this));
        //this.setScreen(new OptionMenu(this));
        //this.setScreen(new PauseMenu(this));
        
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

}
