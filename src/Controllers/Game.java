package Controllers;

import Models.Locations.Location;
import Models.*;
import View.GUI;

import java.util.*;

public class Game {
    HashMap<String, Location> locations;
    Location actualPlace;
    GUI gui;
    Player player;
    //ChoiceHandler choiceHandler;
    public Game() {
        this.gui = new GUI();
        this.player = new Player();// Estos valores se definen con JSON

        //choiceHandler = new ChoiceHandler();

    }


    public void setLocations(HashMap<String, Location> locations) {
        this.locations = locations;
    }

    public void setActualPlace(String place){
        this.actualPlace = locations.get(place);
        gui.setMainText(actualPlace);
        gui.setButtons(actualPlace);


        //Esto hara que la opcion que se escogida en los botones llegue al
        //gui.choiceHandler = actualPlace;//.actionPerformed();

    }
}
