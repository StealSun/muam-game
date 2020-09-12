package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class item {
    public Image img;

    public int x, y;
    public Boolean act;
    Timer timeUpdate;

    public item(Image img) {
        timeUpdate = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vinz();
            }
        });

        this.img = img;
        act = false;
    }

    public void start() {
        timeUpdate.start();
        y = 0;
        x = (int) (Math.random() * 1000);
        act = true;
    }

    public void vinz() {
        if (act == true) {
            y += 1;
        }
        if ((y + img.getHeight(null)) >= 1000) {
            timeUpdate.stop();
        }
    }

    public void draw(Graphics gr) {
        if (act == true) {
            gr.drawImage(img, x, y, null);
        }
    }
}
