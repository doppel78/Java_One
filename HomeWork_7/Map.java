package GeekBrains_Java_One.HomeWork_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    int maxBTN;
    JButton[] btn;

    Map() {
        setBackground(Color.GRAY);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        maxBTN = fieldSizeX * fieldSizeY;
        btn = new JButton[maxBTN];
        for( int i = 0; i < btn.length; i++) {
            btn[i]=new JButton();
            add(btn[i]);
            btn[i].setBackground(Color.CYAN);
        }
        setLayout(new GridLayout(fieldSizeY,fieldSizeX));
        updateUI();
    }

    void clearGame() {
        for (int i = 0; i < maxBTN; i++) {
            remove(btn[i]);
        }
        updateUI();
    }
}
