package game;

import javax.swing.JOptionPane;

// Game main Class
public class game {
    // run game
    public static void main(String[] args) {

        // Select difficulty
        String res = JOptionPane.showInputDialog(null, "Введите сложность (От 1 до 7):", "Сложность игры", 1);

        int difficulty = Integer.parseInt(res);

        if ((difficulty >= 1) & (difficulty <= 7)) {
            window window = new window(difficulty);
        }
    }
}
