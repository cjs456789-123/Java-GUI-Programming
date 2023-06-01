package UpDownGame;

import UpDownGame.PrimaryPanel;

import javax.swing.JFrame;

public class UpDownGame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("UP-DOWN-GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        PrimaryPanel primary = new PrimaryPanel();
        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);
    }

}
