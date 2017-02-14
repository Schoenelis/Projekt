package com.game.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.managers.GameKeys;
import com.game.managers.GameStateManager;
import com.game.obj.Blackhole;
import com.game.obj.BulletGegner;
import com.game.obj.BulletPlayer;
import com.game.obj.Gegner;
import com.game.obj.Player;

public class PlayState extends GameState {

    private ShapeRenderer sr;

    private Blackhole blackhole;
    private Player player;
    private Gegner gegner;
    private ArrayList<BulletPlayer> bulletsPlayer;
    private ArrayList<BulletGegner> bulletsGegner;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

        sr = new ShapeRenderer();

        bulletsGegner = new ArrayList<BulletGegner>();
        bulletsPlayer = new ArrayList<BulletPlayer>();

        blackhole = new Blackhole();

        player = new Player(bulletsPlayer);

        gegner = new Gegner(bulletsGegner);

    }

    @Override
    public void update(float dt) {

        // get user input
        handleInput();

        // update player
        player.update(dt);

        gegner.update(dt);
        // update blackhole
        blackhole.update();

        // Update Bullets Gegner
        for (int j = 0; j < bulletsGegner.size(); j++) {
            bulletsGegner.get(j).update(dt);
            if (bulletsGegner.get(j).shouldRemove()) {
                bulletsGegner.remove(j);
                j--;
            }
        }
//         update player bulletsPlayer
        for (int i = 0; i < bulletsPlayer.size(); i++) {
            bulletsPlayer.get(i).update(dt);
            if (bulletsPlayer.get(i).shouldRemove()) {
                bulletsPlayer.remove(i);
                i--;
            }
        }

//        Rectangle boundingRectangle0 = Gegner.sprite.getBoundingRectangle();
//        Rectangle boundingRectangle1 = BulletGegner.sprite.getBoundingRectangle();
//        Rectangle boundingRectangle2 = Player.sprite.getBoundingRectangle();
//        Rectangle boundingRectangle3 = BulletPlayer.sprite.getBoundingRectangle();
//        Rectangle boundingRectangle4 = Blackhole.sprite.getBoundingRectangle();

        if (Player.playerLife && !Gegner.gegnerLife) {
            System.out.println("Gewonnen");
        } else if (!Player.playerLife && !Gegner.gegnerLife) {
            System.out.println("Verloren");
        } else if (!Player.playerLife) {
            System.out.println("Verloren");
        }

        //Player Aktion
        if (Player.pShoot && Gegner.boundingRectangle_Gegner.contains(Gegner.sprite.getX(), BulletPlayer.sprite.getY())) {
            System.out.println("Treffer  Gegner " + Player.pShoot);
            Gegner.maxEnergy = Gegner.maxEnergy -17;
            System.out.println("gegner Energx" +Gegner.maxEnergy);
            Player.pShoot = false;
        }

        //Zusammen stoß mit gegner erkennen.
        if (Gegner.boundingRectangle_Gegner.contains(Player.px, Player.py)) {
            System.out.println("Zusammenstoß Gegner");
            Player.playerLife = false;
            Gegner.gegnerLife = false;
        }
        
      

        //Beruehrung mit schwartzenloch erkennen.
        if (Blackhole.boundingRectangle_Blackhole.contains(Player.px, Player.py)) {
            System.out.println("Zusammenstoß Schwartzes loch");
            Player.px = 600;
            Player.py = 50;
            //Player.playerLife =false;
        }

        //Gegner Aktion
        if (Gegner.gShoot && BulletGegner.boundingRectangle_GegnerBullet.overlaps(Player.boundingRectangle_Player)) {
            System.out.println("Treffer  Player " + Gegner.gShoot);         
            Player.maxEnergy =  Player.maxEnergy -10;
            System.out.println("Player Energy " +Player.maxEnergy);
            Gegner.gShoot = false;
        }

    }

    @Override
    public void draw() {
        if (Gegner.gegnerLife) {
            // draw player
            player.draw();
            gegner.draw();

            // draw bulletsPlayer
            for (int i = 0; i < bulletsPlayer.size(); i++) {
                bulletsPlayer.get(i).draw();
            }
            // draw bulletsPlayer
            for (int j = 0; j < bulletsGegner.size(); j++) {
                bulletsGegner.get(j).draw();
            }
            blackhole.draw();
        } else {
            // draw player
            player.draw();

            blackhole.draw();
            // draw bulletsPlayer
            for (int i = 0; i < bulletsPlayer.size(); i++) {
                bulletsPlayer.get(i).draw();
            }
            // gegner.draw();
        }
    }

    @Override
    public void handleInput() {
        player.setLeft(GameKeys.isDown(GameKeys.LEFT));
        player.setRight(GameKeys.isDown(GameKeys.RIGHT));
        player.setUp(GameKeys.isDown(GameKeys.UP));
        if (GameKeys.isPressed(GameKeys.SPACE)) {
            player.shoot();
        }
    }

    @Override
    public void dispose() {
    }

}
