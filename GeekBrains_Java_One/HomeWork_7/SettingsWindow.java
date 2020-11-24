package GeekBrains_Java_One.HomeWork_7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE_X = 3;
    private static final int MIN_FIELD_SIZE_Y = 3;
    private static final int MAX_FIELD_SIZE_X = 10;
    private static final int MAX_FIELD_SIZE_Y = 10;
    private static final String FIELD_SIZE_PREFIX = "Field size is: ";
    private static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private final GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSizeX;
    private JSlider slideFieldSizeY;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        int posX = gameWindow.getX() + 50;
        int posY = gameWindow.getY() + 50;
        setLocation(posX, posY);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(13, 1));
        addGameModeControls();
        addFieldControls();
        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStart);
    }

    // изменение позиции окна установок при перемещении основного окна
    void resizePosition() {
        int posX = gameWindow.getX() + 50;
        int posY = gameWindow.getY() + 50;
        setLocation(posX, posY);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode"));
        humVSAI = new JRadioButton("Human vs. AI");
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        humVSAI.setSelected(true);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControls() {
        JLabel lbFieldSizeX = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE_X);
        JLabel lbFieldSizeY = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE_Y);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSizeX = new JSlider(MIN_FIELD_SIZE_X, MAX_FIELD_SIZE_X, MIN_FIELD_SIZE_X);
        slideFieldSizeY = new JSlider(MIN_FIELD_SIZE_Y, MAX_FIELD_SIZE_Y, MIN_FIELD_SIZE_Y);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_WIN_LENGTH, MIN_WIN_LENGTH);

        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        slideFieldSizeX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbFieldSizeX.setText(FIELD_SIZE_PREFIX + slideFieldSizeX.getValue());
                if(slideFieldSizeX.getValue() <= slideFieldSizeY.getValue()) {
                    slideWinLen.setMaximum(slideFieldSizeX.getValue());
                }

            }
        });

        slideFieldSizeY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbFieldSizeY.setText(FIELD_SIZE_PREFIX + slideFieldSizeY.getValue());
                if(slideFieldSizeY.getValue() <= slideFieldSizeX.getValue()) {
                    slideWinLen.setMaximum(slideFieldSizeY.getValue());
                }
            }
        });

        add(new JLabel("Choose field size X"));
        add(lbFieldSizeX);
        add(slideFieldSizeX);
        add(new JLabel("Choose field size Y"));
        add(lbFieldSizeY);
        add(slideFieldSizeY);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void btnStartClick() {
        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode");
        }
        int fieldSizeX = slideFieldSizeX.getValue();
        int fieldSizeY = slideFieldSizeY.getValue();
        int winLen = slideWinLen.getValue();

        gameWindow.applySettings(gameMode, fieldSizeX, fieldSizeY, winLen);

        setVisible(false);
    }
}
