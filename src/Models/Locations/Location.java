package Models.Locations;

import Controllers.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Location implements ActionListener {
    String[] options;
    String mainString;
    Game rpg;

    public Location(String[] options, Game rpg) {
        this.options = options;
        this.rpg = rpg;
        mainString = "testing";
    }

    public void actionPerformed(ActionEvent event){
        String choice = event.getActionCommand();
        switch (choice){
            case "c1":command1();break;
            case "c2":command2();break;
            case "c3":command3();break;
            case "Save":rpg.savePlayerData();break;
        }
    }

    abstract void command1();
    abstract void command2();
    abstract void command3();
    public String[] getOptions() {
        return options;
    }
    public String getMainString() {
        return mainString;
    }
    public Game getRpg() {
        return rpg;
    }
}
