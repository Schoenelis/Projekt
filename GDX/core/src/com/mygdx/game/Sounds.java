
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;


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

