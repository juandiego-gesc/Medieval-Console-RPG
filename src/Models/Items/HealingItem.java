package Models.Items;

public class HealingItem extends Item{
    int buyingPrice;

    public HealingItem(int id, String name) {
        super(id, name);
    }

    public int getBuyingPrice(){
        return buyingPrice;
    }
}
