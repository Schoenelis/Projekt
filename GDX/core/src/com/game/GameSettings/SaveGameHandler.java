package com.game.GameSettings;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

import java.io.IOException;
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

    private static final String Primary_Save_DATA_PATH = "primayrysave.dat";
    private static final String Secondary_Save_DATA_PATH = "secondarysave.dat";
    private static String RAW_SAVE_DATA;
    private static String ENCRYPTED_DATA;
    private static String SAVE_DATA;
    private static Element root;
    private static Element player;
    private static String level;
    private static String life;
    private static String curency;
    private static String energy;
    private static int savecount;
    private static String gameversion;
    private static String gameid;

    public SaveGameHandler() {
        readXml();
        setAttribute();
        writeXml();
    }

    private static void writeXml() {

        if (savecount > 30) {
            int savecounta = savecount;
            savecount = 0;

            SAVE_DATA = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "\n"
                    + "\n"
                    + "<savegame savecount = '" + savecount + "' gameversion=\"" + gameversion + "\" gameid=\"" + gameid + "\">   \n"
                    + "    \n"
                    + "    \n"
                    + "    <player level=\"" + level + "\" life=\"" + life + "\" curency=\"" + curency + "\" energy=\"" + energy + "\" >   \n"
                    + "    \n"
                    + "    \n"
                    + "    </player>   \n"
                    + "    \n"
                    + "</savegame>";

            Gdx.files.local(Secondary_Save_DATA_PATH).writeString(SAVE_DATA, false);

            Gdx.files.local(Primary_Save_DATA_PATH).writeString(SAVE_DATA, false);
            System.out.println(SAVE_DATA);
        } else {
            SAVE_DATA = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "\n"
                    + "\n"
                    + "<savegame savecount = '" + savecount + "' gameversion=\"" + gameversion + "\" gameid=\"" + gameid + "\">   \n"
                    + "    \n"
                    + "    \n"
                    + "    <player level=\"" + level + "\" life=\"" + life + "\" curency=\"" + curency + "\" energy=\"" + energy + "\" >   \n"
                    + "    \n"
                    + "    \n"
                    + "    </player>   \n"
                    + "    \n"
                    + "</savegame>";

            System.out.println(SAVE_DATA);

            Gdx.files.local(Primary_Save_DATA_PATH).writeString(SAVE_DATA, false);
        }
    }

    private static void readXml() {
        try {
            root = new XmlReader().parse(Gdx.files.internal(Primary_Save_DATA_PATH));

            savecount = Integer.parseInt(root.getAttribute("savecount"));
            gameversion = root.getAttribute("gameversion");
            gameid = root.getAttribute("gameid");
            player = root.getChildByName("player");
            level = player.getAttribute("level");
            life = player.getAttribute("life");
            energy = player.getAttribute("energy");
            curency = player.getAttribute("curency");
        } catch (IOException ex) {
            System.err.print(ex);

        }

    }

    @Override
    public void create() {

    }

    public static void setAttribute() {

        level = "1";
        life = "10";
        curency = "10";
        energy = "85";
        savecount++;
        gameversion = GameSettings.getBuildnummer();
        gameid = GameSettings.getGame_Id();

    }
}
