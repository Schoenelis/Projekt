package com.game.obj;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends GameObj {

    private float lifeTime;
    private float lifeTimer;
    private Texture img;

    private boolean remove;

    public Bullet() {
        
        img = new Texture("badlogic.jpg");
        spriteBatch = new SpriteBatch();

        this.x = x;
        this.y = y;

        float speed = 350;
        vx = 400 * speed;
        vy = 400 * speed;

        width = height = 20;

        lifeTimer = 0;
        lifeTime = 1;
    }

    public boolean isRemove() {
        return remove;
    }

    public void update() {
        x += vx * dt;
        y += vy * dt;

        windowCollision();

        lifeTimer += dt;
        if (lifeTimer > lifeTime) {
            remove = true;
        }
    }

    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(img, x, y, width, height);
        spriteBatch.end();
    }

}
