package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.game.GameSettings.GameSettings;

public class Player {

    public static float playerA = 100f;
    public static float playerMaxSpeed1 = 200f;
    public static float playerMaxSpeed2 = -200f;
    public static float x;
    public static float y;
    public static float vx = 0;
    public static float vy = 0;
    public static float width = 100;
    public static float height = 100;

    public static float leben = 1;

    float dt = Gdx.graphics.getDeltaTime();

    public void movePlayerAll() {

        movePlayerDown();
        movePlayerLeft();
        movePlayerRight();
        movePlayerUp();

        // Position des Spielers aus alter Position und Geschwindigkeit
        x += vx * dt;
        y += vy * dt;
    }

    public void movePlayerUp() {
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            vy += dt * playerA;
            if (vy >= playerMaxSpeed1) {
                vy = playerMaxSpeed1;
            }
        }
    }

    public void movePlayerDown() {
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            vy -= dt * playerA;
            if (vy < playerMaxSpeed2) {
                vy = playerMaxSpeed2;
            }
        }
    }

    public void movePlayerLeft() {
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            vx -= dt * playerA;
            if (vx <= playerMaxSpeed2) {
                vx = playerMaxSpeed2;
            }
        }
    }

    public void movePlayerRight() {
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            vx += dt * playerA;
            if (vx >= playerMaxSpeed1) {
                vx = playerMaxSpeed1;
            }
        }
    }

    public void koolisionFenster() {
        // Fenster Koolision Unten
        if (y < 0) {
            y = 0;
            vy = 0;
        }
        // Fenster Koolision Oben
        if (y >= GameSettings.getMain_Frame_Height() - Player.height) {
            y = GameSettings.getMain_Frame_Height() - Player.height;
            vy = 0;
            // Level geschafft
        }
        // Fenster Rechts durchgang nach Links
        if (x >= GameSettings.getMain_Frame_Width() + Player.width / 2) {
            x = -Player.width;
        }
        // Fenster Links durchgang nach Rechts
        if (x < -Player.width) {
            x = GameSettings.getMain_Frame_Width();
        }
    }



}
