package com.game.GameSettings;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.IOException;

/**
 *
 * @author Dreissa
 * @version 0.1
 *
 * Write the Save Game to the xml file.
 *
 */
public class SaveGameHandler extends Game{

    static String Save_DATA_PATH = "SaveGame.xml";
    private static String RAW_SAVE_DATA;
    private static String ENCRYPTED_DATA;
    private static String SAVE_DATA;

    public SaveGameHandler() {
        readXml();
    }

    private String writeXml(String SAVE) {
        return "";
    }

    private static String readXml() {
      String temp = "";
         String e ="";
      try {
            Element root = new XmlReader().parse(Gdx.files.internal("Savegame.xml"));
             temp = "savecount "+ root.getAttribute("savecount");
            temp += "\ngameversion " + root.getAttribute("gameversion");
             temp += "\ngameid " + root.getAttribute("gameid");
           // System.out.println(temp);
        } catch (IOException ex) {
            System.err.print(ex);
        }
             
     
       
        return temp;
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
