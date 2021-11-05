package Models.Items;

public class Loot extends Item{
    int sellingPrice;

    public Loot(int id, String name, int sellingPrice) {
        super(id, name);
        this.sellingPrice=sellingPrice;
    }

    public int getSellingPrice(){
        return sellingPrice;
    }
}
