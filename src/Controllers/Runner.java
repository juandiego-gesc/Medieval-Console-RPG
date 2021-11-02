package Controllers;

import Models.Locations.City;
import Models.Locations.Location;

import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        Game rpg = new Game();
        rpg.setLocations(setUpPlaces(rpg));
        rpg.gui.setUpButtons(rpg.locations.get("Ciudad"));
        rpg.setActualPlace("Ciudad");
    }
    private static HashMap<String, Location> setUpPlaces(Game rpg) {
        HashMap<String,Location> temp = new HashMap<>();
        temp.put("Ciudad",new City(new String[]{"Tienda", "Herrero", "Ir a la Mision"}, rpg));
        //temp.put("tienda", new Tienda(..));
        //...
        return temp;
    }
    //setup places
}
