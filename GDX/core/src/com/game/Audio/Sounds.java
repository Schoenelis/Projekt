
package com.game.Audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
/**
 * 
 * Verwaltet die Audio ausgabe des Spiels
 * @author info
 * @version 0.01
 */

public class Sounds{
    Sound sound;

    public Sounds() {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("Sound.mp3"));
        sound.setLooping(0,true);
        long id = sound.play(1.0f);
        sound.setLooping(id, true);
        sound.setVolume(0,1f);
        sound.play();
    }     
}

