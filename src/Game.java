import java.util.*;

public class Game {
    HashMap<String,Location> locations;
    Location actualPlace;
    GUI gui;
    //ChoiceHandler choiceHandler;
    public Game() {
        this.gui = new GUI();

        //choiceHandler = new ChoiceHandler();

    }

//    private HashMap<String,Location> setUpPlaces() {
//        HashMap<String,Location> temp = new HashMap<>();
//        temp.put("Ciudad",new City(new String[]{"Tienda", "Herrero", "Ir a la Mision"}));
//        //temp.put("tienda", new Tienda(..));
//        //...
//        return temp;
//    }


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
