package com.game.GameSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Dreissa
 * @version 0.1
 *
 * Write the Save Game to the xml file.
 *
 */
public abstract class SaveGameHandler extends XmlReader {

    static String Save_DATA_PATH = "SaveGame.xml";
    private static String RAW_SAVE_DATA;
    private static String ENCRYPTED_DATA;
    private static String SAVE_DATA;

    public SaveGameHandler() {
        String temp = "test ";

        System.out.println(temp + "1");
        try {
//         Element root = new XmlReader().parse(Gdx.files.internal("Savegame.xml"));
//         temp = root.getChildByName("player").getAttribute("level");

            Element root = new XmlReader().parse(Gdx.files.internal("Sprite.xml"));
            temp = root.getChildByName("background").getAttribute("texture");
            System.out.println(temp);

        } catch (IOException ex) {
            Logger.getLogger(SaveGameHandler.class.getName()).log(Level.SEVERE, null, ex);
            //System.err.print(ex);
        }

        // Element root = new XmlReader().parse(Gdx.files.internal("Savegame.xml"));
        System.out.println(temp);

    }

    private String writeXml(String SAVE) {
        return "";
    }

    private static String readXml() {
           String temp = "test ";

        System.out.println(temp + "1");
        
        temp = new XmlReader().parse("Savegame.xml").getAttribute("test");
        
        System.out.println(temp);

        // Element root = new XmlReader().parse(Gdx.files.internal("Savegame.xml"));
        System.out.println(temp);

        return temp;
    }

    private String encryptSave(String RAW_SAVE_DATA) {
        
        return "";
    }

    private String decryptSave(String ENCRYPTED_DATA) {
        return "";
    }

    public static void main(String[] args) {
        SaveGameHandler.readXml();
    }

   

    
}
