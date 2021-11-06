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
        rpg.setItems(setUpItems(rpg));
        rpg.setEnemies(setUpEnemies(rpg));
        rpg.setLocations(setUpPlaces(rpg));
        rpg.gui.setUpButtons(rpg.locations.get("Ciudad"));
        rpg.setActualPlace("Ciudad");
    }

    private static HashMap<Integer, Item> setUpItems(Game rpg) {
        HashMap<Integer,Item> temp = new HashMap<>();
        temp.put(1, new HealingItem(1, "pocion LVL 1", 30,20)); //pocion LVL 1
        temp.put(2, new HealingItem(2, "pocion LVL 2", 60,35)); //pocion LVL 2
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
    
    private static HashMap<Integer, Enemy> setUpEnemies(Game rpg){
        HashMap<Integer, Enemy> temp = new HashMap<>();
        temp.put(1 ,new Enemy(70, new int[]{10, 15},"Te has encontrado con un lobo feroz.\n¿Qué vas a hacer?",rpg.items.get(3)));//lobo1
        temp.put(2 ,new Enemy(100, new int[]{10, 20},"Te has encontrado con un goblin.\nParece que esta furioso ¡ten cuidado!",rpg.items.get(4)));//goblin
        temp.put(3 ,new Enemy(80, new int[]{10, 30},"Te has encontrado con un lobo feroz.\n ¿Qué vas a hacer?",rpg.items.get(3)));//lobo2
        temp.put(4 ,new Enemy(240, new int[]{20, 30},"Te has encontrado un esqueleto\n¿Qué vas a hacer?",rpg.items.get(4)));//Esqueleto
        temp.put(5 ,new Enemy(500, new int[]{30, 60},"¡Has encontrado al dragón de las mazmorras!\n¡Cuidado que no te queme!",rpg.items.get(4)));//Dragon
        return temp;
    }

    private static HashMap<String, Location> setUpPlaces(Game rpg) {
        HashMap<String,Location> temp = new HashMap<>();

        temp.put("Ciudad",new City(new String[]{"Tienda", "Herrero", "Tablero"}, rpg));

        temp.put("Tienda", new Shop(new String[]{"Comprar", "Vender", "Volver"},rpg));

        temp.put("MenuTienda", new ShopMenu(new String[]{"Comprar", "Vender", "Volver"},rpg));

        temp.put("Mazmorra",new Dungeon(new String[]{"Atacar", "Avanzar","Volver"},rpg,rpg.enemies.get(4),rpg.enemies.get(5)));

        temp.put("Bosque",new Forest(new String[]{"Atacar", "Avanzar", "Volver"}, rpg, rpg.enemies.get(2)));

        temp.put("Llanuras",new Plains(new String[]{"Atacar", "Avanzar", "Volver"}, rpg, rpg.enemies.get(1), rpg.enemies.get(3)));

        temp.put("Herrero", new Blacksmith(new String[]{"Mejorar arma","Mejorar armadura", "Volver"},rpg));

        temp.put("Combate1",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,rpg.enemies.get(1),temp.get("Llanuras"),false,false,false)); //Lobo, Llanura, no, no, no
        temp.put("Combate2",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,rpg.enemies.get(2),temp.get("Bosque"),true,true,true)); //Goblin, Forest, si, si, si
        temp.put("Combate3",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,rpg.enemies.get(3),temp.get("Llanuras"),false,false,false)); //Lobo, Llanura, no, no, no
        temp.put("Combate4",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,rpg.enemies.get(4),temp.get("Mazmorra"),true,false,false)); //Esqueleto, Dungeon, si, no, no
        temp.put("Combate5",new Combat(new String[]{"Atacar", "Huir", "Curarse"}, rpg,rpg.enemies.get(5),temp.get("Mazmorra"),false,true,false)); //Dragon, Dungeon, no, si, no


        temp.put("Tablero",new QuestBoard(new String[]{"Goblin", "Dragon", "Volver"}, rpg));

        return temp;
    }
}
