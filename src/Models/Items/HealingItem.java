package Models.Items;

import java.awt.event.ActionEvent;

public class HealingItem extends Item{
    int buyingPrice;

    public HealingItem(int id, String name) {
        super(id, name);
    }

    public int getBuyingPrice(){
        return buyingPrice;
    }

}
