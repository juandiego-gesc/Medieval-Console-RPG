package Controllers;

import Models.Enemy;
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
        rpg.setItems(setUpItems(rpg));
        rpg.setEnemies(setUpEnemies(rpg));
        rpg.gui.setUpButtons(rpg.locations.get("Ciudad"));
        rpg.setActualPlace("Ciudad");
    }

    private static HashMap<Integer, Item> setUpItems() {
        HashMap<Integer,Item> temp = new HashMap<>();
        temp.put(1, new HealingItem(1, "pocion LVL 1", 25,20)); //pocion LVL 1
        temp.put(2, new HealingItem(2, "pocion LVL 2", 50,35)); //pocion LVL 2
        temp.put(3, new Loot(3, "Piel de lobo", 40)); //Piel de Lobo
        temp.put(4, new Loot(4, "Carne", 20)); //Carne
        temp.put(5, new Weapon(5, "Espada de madera", 25)); //Espada de madera
        temp.put(6, new Weapon(6, "Espada de hierro", 50)); //Espada de hierro

        HashMap<Item, Integer> startingInv = new HashMap<>();
        startingInv.put(temp.get(5), 1);
        startingInv.put(temp.get(1), 1);

        rpg.player.setInventory(startingInv);
        return temp;
    }

    private static HashMap<String, Location> setUpPlaces(Game rpg) {
        HashMap<String,Location> temp = new HashMap<>();
        temp.put("Ciudad",new City(new String[]{"Tienda", "Herrero", "Ir a la Mision"}, rpg));

        temp.put("Tienda", new Shop(new String[]{"Comprar", "Vender", "Volver"},rpg));

        temp.put("MenuTienda", new ShopMenu(new String[]{"Comprar", "Vender", "Volver"},rpg));

        temp.put("Mazmorra",new Dungeon(new String[]{"Atacar", "Avanzar", "Volver"}, rpg,
                "Has entrado en las catacumbas, abran muchos enemigos por aquí... Ten cuidado", enemies[3], enemies[4]));

        temp.put("Bosque",new Forest(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));

        temp.put("Llanuras",new Plains(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));

        //En todos estos toca decir que enemigo hay, donde esta ocurriendo la pelea, si da vida extra, si cambia el estado del juego o si da recompensa e
        temp.put("Combate1",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,enemies[0],temp.get("Llanuras"),false,false,false)); //Lobo, Llanura, no, no, no
        temp.put("Combate2",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,enemies[1],temp.get("Bosque"),true,true,true)); //Goblin, Forest, si, si, si
        temp.put("Combate3",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,enemies[2],temp.get("Llanuras"),false,false,false)); //Lobo, Llanura, no, no, no
        temp.put("Combate4",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,enemies[3],temp.get("Mazmorra"),true,false,false)); //Esqueleto, Dungeon, si, no, no
        temp.put("Combate5",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,enemies[4],temp.get("Mazmorra"),false,true,false)); //Dragon, Dungeon, no, si, no


        temp.put("Tablero",new QuestBoard(new String[]{"Atacar", "Avanzar", "Volver"}, rpg));

        return temp;
    }

}
