import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.*;

public class GUI {
    private String mainText;
    private ArrayList<JButton> conmmands;
    private int health;
    private int attack;
    private int gold;
    private final int nButtons = 3;
    private ActionListener actionListener; //falta inicializar

    public GUI() {
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
        this.conmmands = new ArrayList<>();
        for(int i = 0; i < nButtons; i++) {
            JButton btn = new JButton("");
            this.actionListener = place;
            btn.addActionListener(actionListener);
            btn.setActionCommand("c"+(i+1));
            //hacer todo el setup del boon
            this.conmmands.add(btn);

        }
    }

    public void setMainText(Location place){
        this.mainText = place.mainString;
    }

    public void setButtons(Location place){
        String[] options = place.options;
        for(int i = 0; i < options.length; i++) {
            JButton btn = this.conmmands.get(i);
            btn.setText(options[i]);

            //update action listener according to the place
            btn.removeActionListener(actionListener);
            this.actionListener = place;
            btn.addActionListener(actionListener);
        }
    }
}
