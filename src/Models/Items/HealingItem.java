package Models.Items;

import java.awt.event.ActionEvent;

public class HealingItem extends Item{
    int buyingPrice;
    int healing;

    public HealingItem(int id, String name, int healing, int price) {
        super(id, name);
        this.healing = healing;
        this.buyingPrice = price;
    }

    public int getBuyingPrice(){
        return buyingPrice;
    }
    public int getHealing(){
        return healing;
    }
}
