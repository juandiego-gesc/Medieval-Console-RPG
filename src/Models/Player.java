package Models;

import Models.Items.Item;
import View.GUI;

import java.util.HashMap;

public class Player {
    public HashMap<Item, Integer> inventory;
    public int hp;
    public int attack;
    public int gold;
    public int gameState;
    public GUI gui;

    public Player(GUI gui) {
        this.gui = gui;
        inventory = new HashMap<>();
        // TODO
        //  add initial inventory Items
        setHp(100);
        setAttack(10);
        setGold(100);
        this.gameState = 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
        gui.setHealth(hp);
    }

    public void setAttack(int attack) {
        this.attack = attack;
        gui.setAttack(attack);
    }

    public void setGold(int gold) {
        this.gold = gold;
        gui.setGold(gold);
    }
}
