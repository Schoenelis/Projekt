package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.profiling.GL20Profiler;

public class MainMenu implements Screen {
    

    private final MyGdxGame game;

    Texture Start_enabled;
    Texture Ende_enabled;
    Texture Einstelungen_enabled;

    Texture Start_disabled;
    Texture Ende_disabled;
    Texture Einstelungen_disabled;

    public MainMenu(MyGdxGame game) {
        this.game = game;
        Start_enabled = new Texture("");
        Start_disabled = new Texture("");
        Ende_enabled = new Texture("");
        Ende_disabled = new Texture("");
        Einstelungen_enabled = new Texture("");
        Einstelungen_disabled = new Texture("");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        
        game.batch.draw(Start_enabled, 100, 100, 50, 50);
        
        
        game.batch.end();

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
