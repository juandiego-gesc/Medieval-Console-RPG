package Models.Items;

public class Weapon extends Item {
    int damage;

    public Weapon(int id, String name) {
        super(id, name);
    }

    public int getDamage(){
        return damage;
    }
}
