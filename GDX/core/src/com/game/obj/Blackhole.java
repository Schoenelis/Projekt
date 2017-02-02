package com.game.obj;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Random;

public class Blackhole extends GameObj {

    private float attraction;
    private ArrayList<Bullet> bullets;

    private Random random;
    private Player player;
    private Texture imgBlackhole;

    public Blackhole() {
        player = new Player(bullets);
        imgBlackhole = new Texture("Game_Grafiken/blackhole.png");
        spriteBatch = new SpriteBatch();
        x = 300;
        y = 300;
        width = height = 200;
        attraction = 3000f;
    }

    private void attraction() {
        double dx = x - player.x;
        double dy = y - player.y;
        double r = Math.hypot(dx, dy);
        double r3 = r * r * r;
        double a = attraction * dt / r3;

        double dvx = a * dx;
        double dvy = a * dy;

        player.vx += dvx;
        player.vy += dvy;
    }

    public void update() {
        attraction();
    }

    public void draw() {
        spriteBatch.begin();
        spriteBatch.draw(imgBlackhole, x, y, width, height);
        spriteBatch.end();
    }
}
