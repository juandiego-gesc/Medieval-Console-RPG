package Models;

import Models.Items.Item;

import java.util.HashMap;

public class Player {
    public HashMap<Item, Integer> inventory;
    public int hp;
    public int attack;
    public int gold;
    public int gameState;

    public Player() {
    }
}
