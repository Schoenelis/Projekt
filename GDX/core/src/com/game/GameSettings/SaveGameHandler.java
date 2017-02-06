package com.game.GameSettings;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.badlogic.gdx.utils.XmlWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dreissa
 * @version 0.1
 *
 * Write the Save Game to the xml file.
 *
 */
public class SaveGameHandler extends Game {

    private static String Save_DATA_PATH = "Savegame.xml";
    private static String RAW_SAVE_DATA;
    private static String ENCRYPTED_DATA;
    private static String SAVE_DATA;
    private static Element root;
    private static Element player;
   

    public SaveGameHandler() {
        readXml();
    }

    private static void writeXml() {
//
//        try {
//            StringWriter writer = new StringWriter();
//
//            XmlWriter xml  = new XmlWriter(writer);
//
//         player.setAttribute("level","2");
//          xml.write(SAVE_DATA);
//
//            
//            System.out.println(writer);
//
//        } catch (IOException ex) {
//            Logger.getLogger(SaveGameHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private static void readXml() {
        try {
            
            root = new XmlReader().parse(Gdx.files.internal(Save_DATA_PATH));

            SAVE_DATA = "\n\nSave info\n";
            SAVE_DATA += "\nsavecount: " + root.getAttribute("savecount");
            SAVE_DATA += "\ngameversion: " + root.getAttribute("gameversion");
            SAVE_DATA += "\ngameid: " + root.getAttribute("gameid");
            SAVE_DATA += "\n\n\nPlayer info\n";
            player = root.getChildByName("player");
            SAVE_DATA += "\nLevel: " + player.getAttribute("level");
            SAVE_DATA += "\nlife: " + player.getAttribute("life");
            SAVE_DATA += "\nEnergy: " + player.getAttribute("energy");
            SAVE_DATA += "\ncurency: " + player.getAttribute("curency");

       //     System.out.println(SAVE_DATA);

           // writeXml();

        } catch (IOException ex) {
            System.err.print(ex);
        }
    }

    private String encryptSave(String RAW_SAVE_DATA) {

        return "";
    }

    private String decryptSave(String ENCRYPTED_DATA) {
        return "";
    }

    @Override
    public void create() {

    }

}
