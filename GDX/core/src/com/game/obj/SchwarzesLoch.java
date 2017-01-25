package com.game.obj;

import com.badlogic.gdx.Gdx;

public class SchwarzesLoch {

    public static float x = 200;
    public static float y = 200;
    public static float anziehung = 30f;
    public static float width = 100;
    public static float height = 100;
    
    Player player = new Player();

    float dt = Gdx.graphics.getDeltaTime();

    public void pullPlayer() {

        if (y > Player.y) {
            Player.vy += dt * anziehung;
            if (Player.vy >= Player.playerMaxSpeed1) {
                Player.vy = Player.playerMaxSpeed1;
            }
        }

        if (x < Player.x) {
            Player.vx -= dt * anziehung;
            if (Player.vx <= Player.playerMaxSpeed2) {
                Player.vx = Player.playerMaxSpeed2;
            }
        }

        if (x > Player.x) {
            Player.vx += dt * anziehung;
            if (Player.vx >= Player.playerMaxSpeed1) {
                Player.vx = Player.playerMaxSpeed1;
            }
        }

        if (y < Player.y) {
            Player.vy -= dt * anziehung;
            if (Player.vy < Player.playerMaxSpeed2) {
                Player.vy = Player.playerMaxSpeed2;
            }
        }
        // Koolision mit Schwarzemloch
        if (x < Player.x + Player.width && y < Player.y + Player.height && x + width > Player.x && y + height > Player.y) {
            System.out.println("tot");
        }
    }
}
