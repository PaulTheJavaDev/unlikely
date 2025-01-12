import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;

public class Clown {

    /*
    Clown
        -killsUser action
        -Sound System
        --make the clown speak (for loop with dialog)
     */

    public static void startDialog(String text) {
        //animate the dialog of the clown also with sound

        for (int i = 0; i < text.length(); i++) {
            //System.out.print(i);
            System.out.print(text.charAt(i));
            try {
                playSound("src/Audio/angry-grunt.wav");
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (i == text.length()) {
                break;
            }

        }

    }

    public static void killUser() {
        System.out.println("");
    }

    public static void loopSound(String location) {
        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } else {
                System.out.println("Can't find File");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void playSound(String soundPath){
        try {
            File backgroundMusic = new File(soundPath); //example: "src/Audio/angry-grunt.wav"
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(backgroundMusic);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //I asked on stack overflow how I could fix the issue with the sound being played randomly, but the code isn't progressing
    //Let's see what will happen or if somebody answers
    public static void randomlyPlaySound(String soundPath, int milliOne, int milliTwo){
        Random random = new Random();

        try {
            int randomMilliseconds = random.nextInt(milliOne, milliTwo) + 1;
            Thread.sleep(randomMilliseconds);
            playSound(soundPath);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
