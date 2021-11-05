package Controllers;

import Models.Items.Item;
import Models.Locations.Location;
import Models.*;
import Models.Locations.TitleScreen;
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
    Location titleScreen;
    public HashMap<Integer, Item> items;
    Location actualPlace;
    GUI gui;
    public Player player;
    String fileName = "src/SavedGame.txt";
    //ChoiceHandler choiceHandler;
    public Game() {
        titleScreen = new TitleScreen(new String[]{"Start", "Continue"}, this);
        this.gui = new GUI(titleScreen);
        this.player = new Player(gui);// Estos valores se definen con JSON
    }


    public void setLocations(HashMap<String, Location> locations) {
        this.locations = locations;
    }

    public void setActualPlace(String place){
        this.actualPlace = locations.get(place);
        gui.setMainText(actualPlace);
        gui.setButtons(actualPlace);
    }
    public void setActualPlace(Location place){
        this.actualPlace = place;
        gui.setMainText(actualPlace);
        gui.setButtons(actualPlace);
    }

    public void setItems(HashMap<Integer, Item> items) {
        this.items = items;
    }

    public void startGame(){
        gui.visibleScreen(true);
//        gui.setUpButtons(locations.get("Ciudad"));
//        setActualPlace("Ciudad");
    }

    public void loadPlayerData(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            HashMap<Item, Integer> newInv = new HashMap<>();

            int mapLength = Integer.parseInt(br.readLine());
            for(int i = 0; i < mapLength; i++){
                Item current = items.get(Integer.parseInt(br.readLine()));
                int amount = Integer.parseInt(br.readLine());
                newInv.put(current, amount);
            }
            player.inventory = newInv;
            player.setHp(Integer.parseInt(br.readLine()));
            player.setAttack(Integer.parseInt(br.readLine()));
            player.setGold(Integer.parseInt(br.readLine()));
            player.gameState = Integer.parseInt(br.readLine());
            br.close();
        }catch (Exception e){
            System.out.println("Unable to retrieve information");
        }

    }
    public void savePlayerData(){
        try{
            //Path file = Paths.get(fileName);
            //Files.newBufferedWriter(file, StandardOpenOption.TRUNCATE_EXISTING);
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            bw.write("This is a test 2");
            bw.newLine();
            for(Item key : player.inventory.keySet()){
                bw.write(key.getId());
                bw.newLine();
                bw.write(player.inventory.get(key));
                bw.newLine();
            }
            bw.write("" + player.hp);bw.newLine();
            bw.write("" + player.attack);bw.newLine();
            bw.write("" + player.gold);bw.newLine();
            bw.write("" + player.gameState);bw.newLine();
            bw.close();

            System.out.println("Game saved successfully");
        }catch (Exception e){
            System.out.println("Unable to save");
        }
    }
}
