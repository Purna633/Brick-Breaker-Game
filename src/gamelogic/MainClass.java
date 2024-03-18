package gamelogic;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainClass {
    private JFrame f;
    private GamePlay gamePlay;
    private JButton continueButton;
    private JButton nextLevelButton;

    public MainClass() {
        f = new JFrame();
        f.setTitle("Brick Breaker");
        f.setSize(700, 600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        gamePlay = new GamePlay();
        f.add(gamePlay);

        // Initialize buttons
        continueButton = new JButton("Continue Level");
        nextLevelButton = new JButton("Next Level");

        f.setVisible(true);

        try {
            File ballMovementFile = new File("D:/Springframework/VeriTech/Brick Breaker Game/movement.wav");
            File collisionFile = new File("D:/Springframework/VeriTech/Brick Breaker Game/collide.wav");
            File gameoverFile = new File("D:/Springframework/VeriTech/Brick Breaker Game/over.wav");
            File gamewinFile = new File("D:/Springframework/VeriTech/Brick Breaker Game/win.wav");

            AudioInputStream ballMovementSound = AudioSystem.getAudioInputStream(ballMovementFile);
            AudioInputStream collisionSound = AudioSystem.getAudioInputStream(collisionFile);
            AudioInputStream overSound = AudioSystem.getAudioInputStream(gameoverFile);
            AudioInputStream winSound = AudioSystem.getAudioInputStream(gamewinFile);

            // Create clips
            Clip ballMovementClip = AudioSystem.getClip();
            ballMovementClip.open(ballMovementSound);
            Clip collisionClip = AudioSystem.getClip();
            collisionClip.open(collisionSound);
            Clip gameOverClip = AudioSystem.getClip();
            gameOverClip.open(overSound);
            Clip gameWinClip = AudioSystem.getClip();
            gameWinClip.open(winSound);

            // Set sound clips in game play
            gamePlay.setSoundClips(ballMovementClip, collisionClip, gameOverClip, gameWinClip);
            // Set buttons in game play
            gamePlay.setButtons(continueButton, nextLevelButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }

}
