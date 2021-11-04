package Controllers;

import Models.Items.HealingItem;
import Models.Items.Item;
import Models.Items.Loot;
import Models.Items.Weapon;
import Models.Locations.*;


import java.util.HashMap;

public class Runner {
    public static void main(String[] args) {
        Game rpg = new Game();
        rpg.setLocations(setUpPlaces(rpg));
        rpg.setItems(setUpItems());
        rpg.gui.setUpButtons(rpg.locations.get("Ciudad"));
        rpg.setActualPlace("Ciudad");

    }

    private static HashMap<Integer, Item> setUpItems() {
        HashMap<Integer,Item> temp = new HashMap<>();
        temp.put(1, new HealingItem()); //pocion LVL 1
        temp.put(2, new HealingItem()); //pocion LVL 2
        temp.put(3, new Loot()); //Piel de Lobo
        temp.put(4, new Loot()); //Carne
        temp.put(5, new Weapon()); //Espada de madera
        temp.put(6, new Weapon()); //Espada de hierro
        // Aca los items van a ser creados con un ID en el hashMap para facilitar el update del jugador
        // los IDs correspondientes a cada item estan en el UML
        return temp;
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
