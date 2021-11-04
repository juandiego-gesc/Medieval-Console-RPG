package Controllers;

import Models.Items.Item;
import Models.Locations.Location;
import Models.*;
import View.GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Game {
    HashMap<String, Location> locations;
    HashMap<Integer, Item> items;
    Location actualPlace;
    GUI gui;
    Player player;
    //ChoiceHandler choiceHandler;
    public Game() {
        this.gui = new GUI();
        this.player = new Player();// Estos valores se definen con JSON
    }


    public void setLocations(HashMap<String, Location> locations) {
        this.locations = locations;
    }

    public void setActualPlace(String place){
        this.actualPlace = locations.get(place);
        gui.setMainText(actualPlace);
        gui.setButtons(actualPlace);
    }

    public void setItems(HashMap<Integer, Item> items) {
        this.items = items;
    }

    public void loadPlayerData(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("/resources/SavedGame.txt"));

            HashMap<Item, Integer> newInv = new HashMap<>();

            int mapLength = Integer.parseInt(br.readLine());
            for(int i = 0; i < mapLength; i++){
                Item current = items.get(Integer.parseInt(br.readLine()));
                int amount = Integer.parseInt(br.readLine());
                newInv.put(current, amount);
            }
            player.inventory = newInv;
            player.hp = Integer.parseInt(br.readLine());
            player.attack = Integer.parseInt(br.readLine());
            player.gold = Integer.parseInt(br.readLine());
            player.gameState = Integer.parseInt(br.readLine());
            br.close();
        }catch (Exception e){
            System.out.println("Unable to retrieve information");
        }

    }
    public void savePlayerData(){
        try{
            Path file = Paths.get("/resources/SavedGame.txt");
            Files.newBufferedWriter(file, StandardOpenOption.TRUNCATE_EXISTING);
            BufferedWriter bw = new BufferedWriter(new FileWriter("/resources/SavedGame.txt"));

            for(Item key : player.inventory.keySet()){
                bw.write(key.getId());
                bw.write(player.inventory.get(key));
            }
            bw.write("" + player.hp);
            bw.write("" + player.attack);
            bw.write("" + player.gold);
            bw.write("" + player.gameState);
            bw.close();
        }catch (Exception e){
            System.out.println("Unable to save");
        }
    }
}
