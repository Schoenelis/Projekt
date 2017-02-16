package com.game.managers;

import com.badlogic.gdx.Game;
import com.game.gamestates.GameState;
import com.game.gamestates.PlayState;
import com.mygdx.game.SpaceLegends;

public class GameStateManager extends Game {

    // current game state
    private GameState gameState;

    public static final int MENU = 0;
    public static final int PLAY = 1;
    SpaceLegends game;

    public GameStateManager() {
        setState(PLAY);
    }

    public void setState(int state) {
        if (gameState != null) {
            gameState.dispose();
        }
        if (state == MENU) {
         
        }
        if (state == PLAY) {
            gameState = new PlayState(this);
        }
    }

    public void update(float dt) {
        gameState.update(dt);
    }

    public void draw() {
        gameState.draw();
    }

    @Override
    public void create() {
    }

}
