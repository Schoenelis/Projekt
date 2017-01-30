package com.mygdx.game;

import com.game.Audio.Sounds;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import static com.game.GameSettings.GameSettings.LoadGameSettings;
import com.game.menu.MainMenu;
import com.game.menu.OptionMenu;

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
        LoadGameSettings();
        sound = new Sounds();
        batch = new SpriteBatch();

        this.setScreen(new MainMenu(this));
        //this.setScreen(new OptionMenu(this));

    }

    public SpaceLegends() {
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

}
