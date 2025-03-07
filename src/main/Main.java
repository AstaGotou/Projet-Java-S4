package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Marmot Lab"); // Creation d'une fenêtre avec titre
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de fermer la fenêtre
        window.setResizable (false); // la fenêtre ne peut pas être redimensionnée

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        gamePanel.jeuSetUp();
        gamePanel.startGameThread();
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
