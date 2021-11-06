package View;

import Models.Locations.Location;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI {
    public JFrame window;
    int windowW = 800;
    int windowH = 600;
    public Container gameContainer, titleContainer;

    JPanel titleNamePanel, titleButtonPanel;
    JPanel mainTextPanel, choiceButtonPanel, playerPanel, inventoryBtnPanel;
    JLabel titleNameLabel;
    JLabel hpLabel, attackLabel, goldLabel;
    JTextArea mainTextArea;
    Font normalFont, titleFont;
    Color textBackground;

    private String mainText;
    private ArrayList<JButton> commands;
    private JButton startButton,continueButton, saveButton;
    private int health = 100;
    private int attack;
    private int gold;
    private final int nButtons = 3;
    private ActionListener actionListener;

    public GUI(Location titleScreen) {
        window = new JFrame();
        window.setSize(windowW, windowH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);

        titleContainer = window.getContentPane();
        gameContainer = window.getContentPane();
        normalFont = new Font("1942 report",Font.PLAIN,30);
        titleFont = new Font("1942 report",Font.PLAIN,90);

        setTitleScreen(titleScreen);
        setGameScreen();
        visibleScreen(false);

    }

    public void visibleScreen(boolean gameScreen) {
        mainTextPanel.setVisible(gameScreen);
        choiceButtonPanel.setVisible(gameScreen);
        playerPanel.setVisible(gameScreen);
        inventoryBtnPanel.setVisible(gameScreen);

        titleNamePanel.setVisible(!gameScreen);
        titleButtonPanel.setVisible(!gameScreen);

    }

    private void setTitleScreen(Location titleScreen) {
        this.titleNamePanel = new JPanel();
        this.titleNamePanel.setBounds(100, 100, 600, 150);
        this.titleNamePanel.setBackground(Color.black);


        this.titleNameLabel = new JLabel("EPIC RPG");
        this.titleNameLabel.setFont(titleFont);
        this.titleNameLabel.setForeground(Color.white);
        this.titleNamePanel.add(titleNameLabel);
        titleContainer.add(titleNamePanel);

        this.titleButtonPanel = new JPanel();
        this.titleButtonPanel.setBounds(300,400,200,150);
        this.titleButtonPanel.setBackground(Color.black);
        this.titleButtonPanel.setLayout(new GridLayout(2, 1));
        titleContainer.add(titleButtonPanel);

        this.startButton = new JButton("START");
        this.startButton.setBackground(textBackground);
        this.startButton.setForeground(Color.white);
        this.startButton.setFont(normalFont);
        this.startButton.setFocusPainted(false);
        this.startButton.addActionListener(titleScreen);
        this.startButton.setActionCommand("Start");
        titleButtonPanel.add(startButton);

        this.continueButton = new JButton("CONTINUE");
        this.continueButton.setBackground(textBackground);
        this.continueButton.setForeground(Color.white);
        this.continueButton.setFont(normalFont);
        this.continueButton.setFocusPainted(false);
        this.continueButton.addActionListener(titleScreen);
        this.continueButton.setActionCommand("Continue");
        titleButtonPanel.add(continueButton);
    }

    public void setUpButtons(Location place) {
        this.commands = new ArrayList<>();
        for(int i = 0; i < nButtons; i++) {
            JButton btn = new JButton("");
            btn.setBackground(textBackground);
            btn.setForeground(Color.white);
            btn.setFont(normalFont);
            btn.setFocusPainted(false);

            this.actionListener = place;
            btn.addActionListener(actionListener);
            btn.setActionCommand("c"+(i+1));
            this.commands.add(btn);
            this.choiceButtonPanel.add(btn);
        }
    }

    public void setMainText(Location place){
        this.mainText = place.getMainString();
        this.mainTextArea.setText(mainText);
    }

    public void setButtons(Location place){
        String[] options = place.getOptions();
        for(int i = 0; i < options.length; i++) {
            JButton btn = this.commands.get(i);
            btn.setText(options[i]);

            //update action listener according to the place
            for( ActionListener al : btn.getActionListeners() ) {
                btn.removeActionListener( al );
            }
            this.actionListener = place;
            btn.addActionListener(actionListener);
        }
        for( ActionListener al : this.saveButton.getActionListeners() ) {
            saveButton.removeActionListener( al );
        }
        saveButton.addActionListener(actionListener);
    }

    public void setHealth(int health) {
        this.health = health;
        this.hpLabel.setText("HP:  " + health + "           ");
    }

    public void setAttack(int attack) {
        this.attack = attack;
        this.attackLabel.setText("Attack:  " + attack + "           ");
    }

    public void setGold(int gold) {
        this.gold = gold;
        this.goldLabel.setText("Gold:  " + gold);
    }

    public void setGameScreen(){
        Rectangle mainTextRectangle = new Rectangle(100, 90, windowW - 200, windowH - 390);
        this.textBackground = Color.BLACK;

        this.mainTextPanel = new JPanel();
        this.mainTextPanel.setBounds(mainTextRectangle);
        this.mainTextPanel.setBackground(textBackground);
        this.gameContainer.add(mainTextPanel);

        this.mainTextArea = new JTextArea("This is a test");
        this.mainTextArea.setBounds(mainTextRectangle);
        this.mainTextArea.setBackground(textBackground);
        this.mainTextArea.setForeground(Color.white);
        this.mainTextArea.setFont(normalFont);
        this.mainTextArea.setLineWrap(true);
        this.mainTextArea.setWrapStyleWord(true);
        this.mainTextPanel.add(mainTextArea);

        this.choiceButtonPanel = new JPanel();
        this.choiceButtonPanel.setBounds(250, 100 + windowH - 340, 300, 150);
        this.choiceButtonPanel.setBackground(Color.black);
        this.choiceButtonPanel.setLayout(new GridLayout(nButtons, 1));
        this.gameContainer.add(choiceButtonPanel);



        this.playerPanel = new JPanel();
        this.playerPanel.setBounds(50, 15, 700, 50);
        this.playerPanel.setBackground(Color.black);
        this.gameContainer.add(playerPanel);

        this.hpLabel = new JLabel("HP: 100             ");
        this.hpLabel.setFont(normalFont);
        this.hpLabel.setForeground(Color.white);
        this.playerPanel.add(hpLabel);

        this.attackLabel = new JLabel("Attack: 999             ");
        this.attackLabel.setFont(normalFont);
        this.attackLabel.setForeground(Color.white);
        this.playerPanel.add(attackLabel);

        this.goldLabel = new JLabel("Gold: 9999");
        this.goldLabel.setFont(normalFont);
        this.goldLabel.setForeground(Color.white);
        this.playerPanel.add(goldLabel);

        this.inventoryBtnPanel = new JPanel();
        this.inventoryBtnPanel.setBounds(windowW - 80, windowH - 100, 50, 50);
        this.inventoryBtnPanel.setBackground(textBackground);
        this.inventoryBtnPanel.setLayout(new GridLayout(1, 1));
        this.gameContainer.add(inventoryBtnPanel);

        this.saveButton = new JButton();
        this.saveButton.setBackground(textBackground);
        this.saveButton.setFocusPainted(false);
        this.saveButton.addActionListener(actionListener);
        this.saveButton.setActionCommand("Save");
        try {
            Image inventoryIcon = ImageIO.read(getClass().getResource("/resources/InventoryIcon.png"))
                    .getScaledInstance(45,45, Image.SCALE_DEFAULT);
            // Source: iconbros.com
            this.saveButton.setIcon(new ImageIcon(inventoryIcon));
        } catch (Exception ex) {
            System.out.println("Icon Failed");
        }
        this.inventoryBtnPanel.add(saveButton);
    }

}
