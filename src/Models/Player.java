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
        // TODO
        //  add initial inventory Items
        this.hpCap = 50;
        setHp(50);
        setAttack(25);
        setGold(100);
        this.gameState = 0;
    }

    public void setHp(int hp){
        this.hp = hp;
        gui.setHealth(this.hp);
    }

    public void heal(int hp) {
        if (this.hp + hp < hpCap) {
            this.hp += hp;
        } else {
            this.hp = hpCap;
        }
        gui.setHealth(this.hp);
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

    public void setInventory(HashMap<Item, Integer> inventory){
        this.inventory = inventory;
    }

}
