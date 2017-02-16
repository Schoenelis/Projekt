/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.GameSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import java.io.IOException;

/**
 *
 * @author Dreissa
 * @version 1.0
 */
public class LevelLoader {

    private static final String DATA_PATH = "level.xml";
    private static String LEVEL_DATA;
    private static XmlReader.Element root;
    private static XmlReader.Element e_level;
    private static XmlReader.Element Blackhole;
    private static XmlReader.Element Gegner;
    private static XmlReader.Element Player;
    //Blackhole
    private static boolean finish;
    private static boolean Blackhole_Aktive;
    private static float Blackhole_Attraction;
    private static float Blackhole_posX;
    private static float Blackhole_posY;
    private static int Blackhole_anz;

    //Gegner
    private static boolean Gegner_aktiv;
    private static float Gegner_energy;
    private static float Gegner_schaden;
    private static float Gegner_posY;

    //Player
    public static float Player_energy;
    public static float Player_schaden;
    public static float Player_posY;

    public LevelLoader(int level) {
        readXml(level);
        createLevel();
    }

    private static void readXml(int level) {
        FileHandle Level = Gdx.files.internal(DATA_PATH);

        if (!Level.exists()) {
            //Gdx.app.exit();
            System.out.println("test");
        } else {
            try {
                root = new XmlReader().parse(Gdx.files.internal(DATA_PATH));
                e_level = root.getChildByName("level" + level);
                finish = Boolean.parseBoolean(e_level.getAttribute("finish"));

                //Blackhole
                Blackhole = e_level.getChildByName("blackhole");
                Blackhole_Aktive = Blackhole.getBooleanAttribute("aktiv");
                Blackhole_Attraction = Blackhole.getFloatAttribute("attraction");
                Blackhole_posX = Blackhole.getFloatAttribute("posX");
                Blackhole_posY = Blackhole.getFloatAttribute("posY");
                Blackhole_anz = Blackhole.getIntAttribute("anz");

                System.out.println("Level" + level + "\n" + finish + "\n" + Blackhole_Aktive + "\n" + Blackhole_Attraction + "\n" + Blackhole_posX + "\n"
                        + Blackhole_posY + "\n" + Blackhole_anz + "\n");

                // Gegner 
                Gegner = e_level.getChildByName("gegner");
                Gegner_aktiv = Gegner.getBooleanAttribute("aktiv");
                Gegner_energy = Gegner.getFloatAttribute("energy");
                Gegner_schaden = Gegner.getFloatAttribute("schaden");
                Gegner_posY = Gegner.getFloatAttribute("posY");
                System.out.println("Level" + level + " Gegner \n" + Gegner_aktiv + "\n" + Gegner_energy + "\n" + Gegner_schaden + "\n" + Gegner_posY);

                //Player
                Player = e_level.getChildByName("player");

                Player_energy = Player.getFloatAttribute("energy");
                Player_schaden = Player.getFloatAttribute("schaden");
                Player_posY = Player.getFloatAttribute("posY");

            } catch (IOException ex) {
                System.err.print(ex);

            }
        }

    }

    private static void createLevel() {

        // set Blackhole Values       
        com.game.obj.Blackhole.setBx(Blackhole_posX);
        com.game.obj.Blackhole.setBy(Blackhole_posY);
        com.game.obj.Blackhole.setAttraction(Blackhole_Attraction);      
        // Set Gegner Values 
        com.game.obj.Gegner.setGy(Gegner_posY);
        com.game.obj.Gegner.setMaxEnergy(Gegner_energy);
        com.game.obj.Gegner.setSchaden(Gegner_schaden);
        //Set Player vales
        com.game.obj.Player.setPy(Gegner_posY);
        com.game.obj.Player.setMaxEnergy(Player_energy);
        com.game.obj.Player.setSchaden(Player_schaden);

    }
}
