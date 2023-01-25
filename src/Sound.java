import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    private static Clip clip;

    public static void playSound(String filePath) {
        try {
            // STOP CURRENT SONG
            if (clip != null) {
                clip.stop();
                clip = null;
            }
            // PLAY NEW SONG
            AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getClassLoader()
                    .getResourceAsStream("music/" + filePath));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
