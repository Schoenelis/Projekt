package com.game.Audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.game.GameSettings.GameSettings;

public class Sounds {

    static Sound sound;//

    //Anlegen der Lautstearke der Audiodatein.
    private static float Menu_Volume = GameSettings.getMenu_Volume();

    //Anlegen der IDs für die Audiodateien. 
    private static long Menu_Music;

    public Sounds() {
        playMenuSound();
        
    }

    public static float getMenu_Volume() {
        return Menu_Volume;
    }

    public static void setMenu_Volume(float Volume) {

        Menu_Volume = Volume;

        System.out.println("Sound New Menu_Volume: " + Volume);

        // 0.5f Setzt die lautstearke auf 50% und 1.0f auf 100%.
        // sound.setVolume(Menu_Music, 5f);
        sound.dispose();

        sound.setVolume(Menu_Music, Menu_Volume);
        playMenuSound();

    }

    public static void playMenuSound() {

        sound = Gdx.audio.newSound(Gdx.files.internal("Sound.mp3"));

        sound.setLooping(0, true);

        Menu_Music = sound.play(0f);

        sound.setLooping(Menu_Music, true);

        sound.setVolume(Menu_Music, Menu_Volume);

        sound.play(Menu_Volume);
    }

}
