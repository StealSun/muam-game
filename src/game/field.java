package game;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class field extends JPanel {

    private Image actor;
    private Image background;
    public int x = 500;
    private int difficulty;
    private item[] gameItems;
    private Image game_over;
    public Timer timerUpdate, timerDraw;
    public int ct = 0;

    public field(int difficulty) {
        this.difficulty = difficulty;

        try {
            actor = ImageIO.read(new File("./assets/actor.png"));
            JOptionPane.showMessageDialog(null, "Actor image uploaded successful!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Actor image upload failed.");
        }

        try {
            background = ImageIO.read(new File("./assets/background.png"));
            JOptionPane.showMessageDialog(null, "Background image uploaded successful!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Background image upload failed.");
        }

        try {
            game_over = ImageIO.read(new File("./assets/gameover.png"));
            JOptionPane.showMessageDialog(null, "Game Over image uploaded successful!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Game Over image upload failed.");
        }

        gameItems = new item[15];
        for (int i = 0; i < 15; i++) {
            try {
                gameItems[i] = new item(ImageIO.read(new File("./assets/items/item" + i + ".png")));
                JOptionPane.showMessageDialog(null, "Item " + i + " image uploaded successful!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Item " + i + " image upload failed.");
            }
        }

        timerUpdate = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        timerDraw.start();
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(background, 0, 0, null);
        gr.drawImage(actor, x, 900, null);

        for (int i = 0; i < 7; i++) {
            gameItems[i].draw(gr);
            if (gameItems[i].act == true) {
                if (gameItems[i].y + gameItems[i].img.getHeight(null) >= 900) {
                    if (Math.abs(gameItems[i].x - x) > 65) {
                        gr.drawImage(game_over, 0, 0, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    } else {
                        gameItems[i].act = false;
                    }
                }
            }
        }
    }

    private void updateStart() {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (gameItems[i].act == false) {
                if (count < difficulty) {
                    gameItems[i].start();
                    ct = ct + 1;
                    break;
                }
            } else {
                count++;
            }
        }
    }
}
