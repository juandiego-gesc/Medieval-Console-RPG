package Models;

import Models.Items.Item;
import View.GUI;

import java.util.HashMap;

public class Player {
    public HashMap<Item, Integer> inventory;
    public int hp;
    public int hpCap;
    public int attack;
    public int gold;
    public int gameState;
    public GUI gui;

    public Player(GUI gui) {
        this.gui = gui;
        inventory = new HashMap<>();
        // TODO
        //  add initial inventory Items
        this.hpCap = 100;
        setHp(100);
        setAttack(10);
        setGold(100);
        this.gameState = 0;
    }

    public void setHp(int hp) {
        if (this.hp + hp < hpCap) {
            this.hp = hp;
        } else {
            this.hp = hpCap;
        }
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

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getGold() {
        return gold;
    }

    public int getGameState() {
        return gameState;
    }
}
