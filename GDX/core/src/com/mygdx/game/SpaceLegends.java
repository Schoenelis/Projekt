/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.game.menu.MainMenu;
import com.game.Audio.Sounds;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.menu.MyGdxGame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hauptklasse des spiels.
 *
 * @author dreissa
 */
public class SpaceLegends extends Game {

    Sounds sound;
    public SpriteBatch batch;

    @Override
    public void create() {
        sound = new Sounds();
        batch = new SpriteBatch();

        this.setScreen(new MyGdxGame(this));

    }

    public SpaceLegends() {
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

}
