package com.mygdx.game;

import com.mygdx.game.obj.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Bewegung {

    public static float playerA = 100f;
    public static float playerMax1 = 200f;
    public static float playerMax2 = -200f;
    public static float playerX;
    public static float playerY;
    public static float playerVX = 0;
    public static float playerVY = 0;

    Player player;

    public void steuerung() {

        player = new Player();

        float dt = Gdx.graphics.getDeltaTime();

        ////Geschwindigkeitsaenderung des Spielers durch Triebwerkseinsatz
        
        // Spieler beschleunigt nach Links
        if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
      
                playerVX -= dt * playerA;
                if(playerVX<= playerMax2){
                    playerVX = playerMax2;
                }
              
            
        }
        // Spieler bewegung nach Rechts
        if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
                
                playerVX += dt * playerA;
                if(playerVX >= playerMax1){
                    playerVX = playerMax1;
                }
           
        }
        // Spieler bewegung nach Oben
        if (Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
            playerVY += dt * playerA;
            if(playerVY >= playerMax1){
                playerVY = playerMax1;
            }
        }
        // Spieler bewegung nach Unten
        if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
            playerVY -= dt * playerA;
            if(playerVY < playerMax2){
                playerVY = playerMax2;
            }
        }

        //// Geschwindigkeitsaenderung des Spielers durch Massenanziehung
        
        
        // Position des Spielers aus alter Position und Geschwindigkeit
        playerX += playerVX * dt;
        playerY += playerVY * dt;

        // Fenster Koolision Unten
        if (playerY < 0) {
            playerY = 0;
            playerVY = 0;
        }
        // Fenster Koolision Oben
        if (playerY >= GameSetings.getHeight() - player.getPlayerheight()) {
            playerY = GameSetings.getHeight() - player.getPlayerheight();
            playerVY = 0;
            // Level geschafft
        }
        // Fenster Rechts durchgang nach Links
        if (playerX >= GameSetings.getWidth() + player.getPlayerwidth() / 2) {
            playerX = -player.getPlayerwidth();
        }
        // Fenster Links durchgang nach Rechts
        if (playerX < -player.getPlayerwidth()) {
            playerX = GameSetings.getWidth();
        }

        System.out.println("v = " + playerVX + " / " + playerVY);

    }
}
