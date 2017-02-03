package com.game.GameSettings;

import com.badlogic.gdx.utils.XmlReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
    }

    private String writeXml(String SAVE) {
        return "";
    }

    private static String readXml() {
           String temp = "test ";
        return temp;
    }

    private String encryptSave(String RAW_SAVE_DATA) {
        
        return "";
    }

    private String decryptSave(String ENCRYPTED_DATA) {
        return "";
    }

    public static void main(String[] args) {
        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Savegame.xml");
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SaveGameHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SaveGameHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveGameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

   

    
}
