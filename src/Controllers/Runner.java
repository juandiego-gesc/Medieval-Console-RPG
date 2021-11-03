package Controllers;

import Models.Locations.*;

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

        temp.put("tienda", new Shop(new String[]{"Comprar", "Vender", "Volver"},rpg));

        temp.put("Mazmorra",new Dungeon(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));

        temp.put("Forest",new Forest(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));

        temp.put("Plains",new Plains(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));

        temp.put("Combat",new Combat(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));
        return temp;
    }
}
