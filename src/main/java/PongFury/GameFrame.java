package PongFury;



import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel panel;

    public GameFrame() {
        this.add(new GamePanel());
        this.setTitle("Pong Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // Removed the redundant empty add method
}