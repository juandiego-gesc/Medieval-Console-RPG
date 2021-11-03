package View;

import Models.Locations.Location;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI {
    JFrame window;
    int windowW = 800;
    int windowH = 600;
    Container container;

    JPanel mainTextPanel, choiceButtonPanel, playerPanel, inventoryBtnPanel;
    JLabel hpLabel, hpLabelNum, attackLabel, attackLabelNum, goldLabel, goldLabelNum;
    JTextArea mainTextArea;
    Font normalFont;
    Color textBackground;

    private String mainText;
    private ArrayList<JButton> commands;
    private JButton inventory;
    private int health = 100;
    private int attack;
    private int gold;
    private final int nButtons = 3;
    private ActionListener actionListener; //falta inicializar

    public GUI() {
        window = new JFrame();
        window.setSize(windowW, windowH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        window.setResizable(false);

        container = window.getContentPane();
        normalFont = new Font("Consolas",Font.PLAIN,30);

        //Game Screen Set up
        Rectangle mainTextRectangle = new Rectangle(100, 100, windowW - 200, windowH - 400);
        textBackground = Color.BLACK;//new Color(255,255,255, 50);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(mainTextRectangle);
        mainTextPanel.setBackground(textBackground);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("This is a test");
        mainTextArea.setBounds(mainTextRectangle);
        mainTextArea.setBackground(textBackground);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 100 + windowH - 340, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(nButtons, 1));
        container.add(choiceButtonPanel);



        playerPanel = new JPanel();
        playerPanel.setBounds(50, 15, 700, 50);
        playerPanel.setBackground(Color.black);
        //playerPanel.setLayout(new GridLayout(1,5));
        container.add(playerPanel);

        hpLabel = new JLabel("HP: 100             ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
//        hpLabelNum = new JLabel();
//        hpLabelNum.setFont(normalFont);
//        hpLabelNum.setForeground(Color.white);
//        playerPanel.add(hpLabelNum);

        attackLabel = new JLabel("Attack: 999             ");
        attackLabel.setFont(normalFont);
        attackLabel.setForeground(Color.white);
        playerPanel.add(attackLabel);
//        attackLabelNum = new JLabel();
//        playerPanel.add(attackLabelNum);

        goldLabel = new JLabel("Gold: 9999");
        goldLabel.setFont(normalFont);
        goldLabel.setForeground(Color.white);
        playerPanel.add(goldLabel);

        inventoryBtnPanel = new JPanel();
        inventoryBtnPanel.setBounds(windowW - 80, windowH - 100, 50, 50);
        inventoryBtnPanel.setBackground(textBackground);
        inventoryBtnPanel.setLayout(new GridLayout(1, 1));
        container.add(inventoryBtnPanel);

        inventory = new JButton();
        inventory.setBackground(textBackground);
        inventory.setFocusPainted(false);
        try {
            Image inventoryIcon = ImageIO.read(getClass().getResource("/resources/InventoryIcon.png"))
                    .getScaledInstance(45,45, Image.SCALE_DEFAULT);
            inventory.setIcon(new ImageIcon(inventoryIcon));
        } catch (Exception ex) {
            System.out.println("Icon Failed");
        }
        inventoryBtnPanel.add(inventory);


        this.mainText = "This is the main text";
        //this.commands = setUpButtons(nButtons);

        //todo el setup de la gui y todo lo que no sea el main text o los comandos
        // JFrame y toda la mamada
        // set de ubicacion de los comandos con grid layout
        // barra de vida, dinero,ataque, localizacion
        // boton de inventario

    }

    public void setUpButtons(Location place) {
        //ArrayList<JButton> temp = new ArrayList<>();
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
            //hacer todo el setup del boon
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
    }

    public void setHealth(int health) {
        this.health = health;
        this.hpLabel.setText("HP:  " + health + "             ");
    }

    public void setAttack(int attack) {
        this.attack = attack;
        this.attackLabel.setText("Attack:  " + attack + "             ");
    }

    public void setGold(int gold) {
        this.gold = gold;
        this.goldLabel.setText("Gold:  " + gold);
    }
}
