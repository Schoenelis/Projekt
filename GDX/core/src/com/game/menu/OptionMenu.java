/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.SpaceLegends;
import com.game.menu.MainMenu.*;

/**
 *
 * @author dreissa
 */
public class OptionMenu implements Screen {

    final SpaceLegends game;
    
    int select;

    public OptionMenu(SpaceLegends game) {
        this.game = game;
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_DOWN)) && select < 2) {
            select++;
        }
        if (Gdx.input.isKeyJustPressed((Input.Keys.DPAD_UP)) && select > 0) {
            select--;
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
      

        game.batch.end();
        com.game.GameSetings.WindowMode.setWindowMode();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
     }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

}
