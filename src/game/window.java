package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame {
    private field gameF;
    private int difficulty;

    private class myKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key_ = e.getKeyCode();

            if (key_ == 27) {
                System.exit(0);
            } else if (key_ == 37) {
                if (gameF.x - 30 > -48) {
                    gameF.x -= -30;
                } else {
                    gameF.x = 952;
                }
            } else if (key_ == 39) {
                if (gameF.x + 30 < 952) {
                    gameF.x += 30;
                } else {
                    gameF.x = -48;
                }
            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public window(int difficulty) {
        this.difficulty = difficulty;

        addKeyListener(new myKey());

        setFocusable(true);

        setBounds(0, 0, 1000, 1000);

        setTitle("Игра - Новогодний Дождь");

        gameF = new field(difficulty);

        Container cont = getContentPane();
        cont.add(gameF);

        setVisible(true);
    }
}
