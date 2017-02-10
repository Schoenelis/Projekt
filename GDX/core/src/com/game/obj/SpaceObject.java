package com.game.obj;

import com.badlogic.gdx.Gdx;

public class SpaceObject {

    protected float x;
    protected float y;
     
    protected float vx;
    protected float vy;

    protected float radians;
    protected float speed;
    protected float rotationSpeed;

    protected int width;
    protected int height;

    protected float[] shapex;
    protected float[] shapey;

    protected static float dt = Gdx.graphics.getDeltaTime();

}
