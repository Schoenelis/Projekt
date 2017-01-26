/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.GameSetings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import static com.game.GameSetings.GameSetings.getMain_Frame_Height;
import static com.game.GameSetings.GameSetings.getMain_Frame_Width;
import static com.game.GameSetings.GameSetings.setMain_Frame_fullscreen;

/**
 *
 * @author info
 */
public class WindowMode {
    
    public static void setWindowMode() {

        Graphics.Monitor currMonitor = Gdx.graphics.getMonitor();
        Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode(currMonitor);

        if (!Gdx.graphics.isFullscreen()) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                Gdx.app.exit();
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
                setMain_Frame_fullscreen(true);
                Gdx.graphics.setFullscreenMode(displayMode);
            }

        }

        if (Gdx.graphics.isFullscreen()) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
                Gdx.app.exit();
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {               
                Gdx.graphics.setWindowedMode(getMain_Frame_Width(), getMain_Frame_Height());
                setMain_Frame_fullscreen(false);
            }
        }

    }
}
