
package com.game.obj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObj {
    public float x;
    public float y;
    protected float vx,vy;
    protected int width,height;
    protected float dt = Gdx.graphics.getDeltaTime();
    
    protected SpriteBatch spriteBatch;
    
    public void windowCollision(){
         // Fenster Koolision Unten
        if (y < 0) {
            y = 0;
            vy = 0;
        }
        // Fenster Koolision Oben
        if (y >= Gdx.graphics.getHeight() - height) {
            y = Gdx.graphics.getHeight() - height;
           
            // Level geschafft
        }
        // Fenster Rechts durchgang nach Links
        if (x >= Gdx.graphics.getWidth() + width / 2) {
            x = -width;
        }
        // Fenster Links durchgang nach Rechts
        if (x < -width) {
            x = Gdx.graphics.getWidth();
        }
    }
}
