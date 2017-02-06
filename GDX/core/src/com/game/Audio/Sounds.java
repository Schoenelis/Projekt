package com.game.Audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.game.GameSettings.GameSettings;

public class Sounds {

    static Sound sound;//

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

    /**
     * Set the Game Volume.
     *
     * @param Volume
     */
    public static void setGame_Volume(float Volume) {
        Game_Volume = Volume;
        System.out.println("\nSound New Game_Volume: " + Volume);
        sound.dispose();
        sound.setVolume(Game_Music, Game_Volume);
        playGameSound();
    }

    public static void setGame_SFX_Volume(float Volume) {
        Game_SFX_Volume = Volume;
        System.out.println("\nSound New SFX_Volume: " + Volume);
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

        // 0.5f Setzt die lautstearke auf 50% und 1.0f auf 100%.
        // sound.setVolume(Menu_Music, 5f);
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

        sound.setLooping(0, true);

        //  Menu_Music = sound.play(0f);
        sound.setVolume(Menu_Music, Menu_Volume);

        sound.play(Menu_Volume);

        sound.setLooping(Menu_Music, true);
    }

    /**
     * Plays the Game Music when you are playing the Game.
     */
    public static void playGameSound() {

        sound.stop(Menu_Music);

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/Sound.mp3"));

//        sound.setLooping(0, true);
        //Game_Music = sound.play(0f);
        sound.setVolume(Game_Music, Game_Volume);

        sound.play(Game_Volume);

        sound.setLooping(0, true);

        sound.setLooping(Game_Music, true);

    }

    /**
     * Plays the Button Sound when you Enter a Buton in the Game.
     */
    public static void playButtonSound() {

        Button_Volume = GameSettings.getButton_Volume();

        sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/ding.wav"));

        //  Button_Sound = sound.play(0f);
        
        sound.setVolume(Button_Sound, Button_Volume);

        sound.play(Button_Volume);
    }

    /**
     * Plays the special effects Sounds for the Game.
     */
    public static void playSFXSounds() {

        //sound = Gdx.audio.newSound(Gdx.files.internal("Game_Sound/Sound.mp3"));
        sound.setLooping(0, true);

        //  Game_SFX_Sound = sound.play(0f);
//        sound.setLooping(Game_SFX_Sound, true);

        sound.setVolume(Game_SFX_Sound, Game_SFX_Volume);

        sound.play(Game_SFX_Volume);
    }

}
