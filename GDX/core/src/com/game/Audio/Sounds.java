package com.game.Audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.game.GameSettings.GameSettings;

/**
 * Handeling the Sounds for the game.
 *
 * @author Dreissa
 * @version 1.0
 */
public class Sounds {

    static Sound sound;///
    static Music music;

    //Creating of the Volume of the Audiofiles.
    private static float Menu_Volume = GameSettings.getMenu_Volume();
    private static float Button_Volume = GameSettings.getButton_Volume();
    private static float Game_Volume = GameSettings.getGame_Volume();
    private static float Game_SFX_Volume = GameSettings.getGame_SFX_Volume();

    //Creatin of the IDs for the Audiofiles. 
    private static final long Menu_Music = 0L;
    private static final long Button_Sound = 1L;
    private static final long Game_Music = 2L;
    private static final long Game_SFX_Sound = 3L;

    private static final long PlayerShoot = 4L;
    private static final long Invader_Killed = 5L;
    private static final long Explosion = 6L;

    /**
     * Set the Game Volume.
     *
     * @param Volume
     */
    public static void setGame_Volume(float Volume) {
        Game_Volume = Volume;
        System.out.println("\nSound New Game_Volume: " + Volume);
//        sound.stop(Game_Music);
//        sound.dispose();
//        sound.setVolume(Game_Music, Game_Volume);
//        playGameSound();
//        music.stop();

//        music.dispose();
//music.play();
//music.pause();
//        music.setVolume(Game_Music);
        playGameSound();

    }

    public static void setGame_SFX_Volume(float Volume) {
        Game_SFX_Volume = Volume;
        System.out.println("\nSound New SFX_Volume: " + Volume);
        sound.stop(Game_SFX_Sound);
        sound.dispose();
        sound.setVolume(Game_SFX_Sound, Game_SFX_Volume);
        playSFXSounds();
    }

    /**
     * Starting the Menu Music at the game start.
     */
    public Sounds() {
        playMenuSound();
    }

    public static void setMenu_Volume(float Volume) {
        Menu_Volume = Volume;

        // 0.5f Setzt die lautstearke auf 50% und 1.0f auf 100%.;
        sound.stop(Menu_Music);
        sound.dispose();
        sound.setVolume(Menu_Music, Menu_Volume);
        playMenuSound();
    }

    /**
     * Stop the sound playing
     */
    public static void stopSound() {
        sound.stop();
        System.out.println("Sound Stop");
    }

    /**
     * Plays the Menu Music when you are at the Main or Option Menu.
     */
    public static void playMenuSound() {

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/Sound.mp3"));

        sound.setVolume(Menu_Music, Menu_Volume);

        sound.play(Menu_Volume);

        sound.setLooping(0, true);

        sound.setLooping(Menu_Music, true);
    }

    /**
     * Plays the Game Music when you are playing the Game. You can use your own
     * music when you hane an mp3 file with the name "gamemusic.mp3" in the
     * folder with the Space Legends.jar
     */
    public static void playGameSound() {

        FileHandle file = Gdx.files.external("gamemusic.mp3");

//        music.stop();/
        if (file.exists()) {
            System.out.println("Externes audio.");
            music = Gdx.audio.newMusic(Gdx.files.external("gamemusic.mp3"));
        } else {
            music = Gdx.audio.newMusic(Gdx.files.internal("Game_Sound/gamemusic.mp3"));
//        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/Sound.mp3"));

//        sound.setLooping(0, true);
            //Game_Music = sound.play(0f);
//            sound.setVolume(Game_Music, Game_Volume);
            music.play();
//            sound.play(Game_Volume);
            music.setVolume(Game_Volume);
            
//            music.setLooping(true);

//            sound.setLooping(2, true);
//
//            sound.setLooping(Game_Music, true);
        }
    }

    /**
     * Plays the Button Sound when you Enter a Buton in the Game.
     */
    public static void playButtonSound() {

        Button_Volume = GameSettings.getButton_Volume();

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/ding.wav"));

        sound.setVolume(Button_Sound, Button_Volume);

        sound.play(Button_Volume);
    }

    /**
     * Plays the special effects Sounds for the Game.
     */
    public static void playSFXSounds() {

        sound.setLooping(3, true);

        sound.setVolume(Game_SFX_Sound, Game_SFX_Volume);

        sound.play(Game_SFX_Volume);
    }

    //Plays the shoot sound
    public static void PlayPlayerShoot() {

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/laser.mp3"));

        sound.setVolume(PlayerShoot, Game_SFX_Volume);

        sound.play(Game_SFX_Volume);
    }

    //plays the Explosion sound 
    public static void PlayExplosion() {

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/explosion.mp3"));
        sound.setVolume(Explosion, Game_SFX_Volume);

        sound.play(Game_SFX_Volume);
    }

    //plays a sound if a Invader Killed 
    public static void PlayInvaderKilled() {

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/invaderkilled.mp3"));

        sound.setVolume(Invader_Killed, Game_SFX_Volume);

        sound.play(Game_SFX_Volume);
    }

}
