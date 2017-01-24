/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author dreissa
 */
public class SpaceLegends extends Game{

    Sounds sound;
    public SpriteBatch batch;

    @Override
    public void create() {
        sound = new Sounds();
        batch = new SpriteBatch();
        this.setScreen(new MainMenu(this));
    }

    public SpaceLegends() {
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

}
