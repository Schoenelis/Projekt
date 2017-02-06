package com.game.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.IntMap;
import com.game.managers.GameInputProcessor;
import com.game.managers.GameKeys;
import com.game.managers.GameStateManager;
import com.mygdx.game.SpaceLegends;

public class MyGdxGame implements Screen {

    public static int WIDTH;
    public static int HEIGHT;

    public static OrthographicCamera cam;

    private GameStateManager gsm;

    public MyGdxGame(SpaceLegends game) {

        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        cam = new OrthographicCamera(WIDTH, HEIGHT);
        cam.translate(WIDTH / 2, HEIGHT / 2);
        cam.update();

        Gdx.input.setInputProcessor(new GameInputProcessor());

        gsm = new GameStateManager();
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
            Gdx.app.exit();
        }
        // clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.draw();

        GameKeys.update();
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
    public void dispose() {
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

}
