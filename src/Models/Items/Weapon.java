package Models.Items;

import Controllers.Game;

public class Weapon extends Item {
    int damage;

    public Weapon(int id, String name, int damage) {
        super(id, name);
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }
}
