package View;

import Models.Locations.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI {
    JFrame window;
    int windowW = 800;
    int windowH = 600;
    Container container;

    JPanel mainTextPanel;
    JTextArea mainTextArea;
    Font normalFont;

    private String mainText;
    private ArrayList<JButton> commands;
    private int health;
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

        container = window.getContentPane();
        normalFont = new Font("Consolas",Font.PLAIN,30);

        //Game Screen Set up
        Rectangle mainTextRectangle = new Rectangle(100, 100, windowW - 200, windowH - 400);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(mainTextRectangle);
        mainTextPanel.setBackground(new Color(255,255,255, 50));
        container.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(mainTextRectangle);
        //mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);








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
            this.actionListener = place;
            btn.addActionListener(actionListener);
            btn.setActionCommand("c"+(i+1));
            //hacer todo el setup del boon
            this.commands.add(btn);

        }
    }

    public void setMainText(Location place){
        this.mainText = place.getMainString();
    }

    public void setButtons(Location place){
        String[] options = place.getOptions();
        for(int i = 0; i < options.length; i++) {
            JButton btn = this.commands.get(i);
            btn.setText(options[i]);

            //update action listener according to the place
            btn.removeActionListener(actionListener);
            this.actionListener = place;
            btn.addActionListener(actionListener);
        }
    }
}
