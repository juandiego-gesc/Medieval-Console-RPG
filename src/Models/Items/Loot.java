package Models.Items;

public class Loot extends Item{
    int sellingPrice;

    public Loot(int id, String name) {
        super(id, name);
    }

    public int getSellingPrice(){
        return sellingPrice;
    }
}
