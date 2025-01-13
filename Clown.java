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

        }
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error :3");
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

    public static void randomlyPlaySound(String soundPath, int milliOne, int milliTwo) {
        // Create a new thread for the sound-playing logic
        Thread soundThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    int randomMilliseconds = random.nextInt(milliOne, milliTwo) + 1;
                    Thread.sleep(randomMilliseconds);

                    // Call your playSound method
                    playSound(soundPath);
                } catch (Exception e) {
                    System.out.println("Error in sound thread: " + e.getMessage());
                }
            }
        });

        soundThread.setDaemon(true); // Make the thread a daemon so it doesn't block JVM shutdown
        soundThread.start(); // Start the thread
    }

}
