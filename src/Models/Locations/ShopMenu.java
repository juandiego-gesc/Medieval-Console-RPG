package Models.Locations;

import Controllers.Game;
import Models.Items.HealingItem;
import Models.Items.Item;
import Models.Items.Loot;

public class ShopMenu extends Location {

    public boolean venta;
    Item[] products;
    Item[] forSale;


    public ShopMenu(String[] options, Game rpg) {
        super(options, rpg);
        this.products = new Item[]{rpg.items.get(1), rpg.items.get(2)};
        this.forSale = new Item[]{rpg.items.get(3), rpg.items.get(4)};
        this.venta = false;
    }

    @Override
    void command1() { //Vender/Comprar primer elemento
        if (venta) {
            if (rpg.player.inventory.get(forSale[0]) > 0) {
                Loot prod1 = (Loot) forSale[0];
                int actualGold = rpg.player.getGold() + prod1.getSellingPrice() * rpg.player.inventory.get(forSale[0]);
                rpg.player.setGold(actualGold);
                rpg.player.inventory.put(forSale[0], 0);
            }
        } else {
            HealingItem prod1 = (HealingItem) products[0];
            if (rpg.player.getGold() >= prod1.getBuyingPrice()) {
                int actualGold = rpg.player.gold - prod1.getBuyingPrice();
                rpg.player.setGold(actualGold);
                rpg.player.inventory.put(prod1, rpg.player.inventory.getOrDefault(products[0], 1));
            }
        }
    }

    @Override
    void command2() { //Vender/Comprar segundo elemento
        if (venta) {
            if (rpg.player.inventory.get(forSale[1]) > 0) {
                Loot prod2 = (Loot) forSale[1];
                int actualGold = rpg.player.getGold() + prod2.getSellingPrice() * rpg.player.inventory.get(forSale[1]);
                rpg.player.setGold(actualGold);
                rpg.player.inventory.put(forSale[1], 0);
            }
        } else {
            HealingItem prod2 = (HealingItem) products[1];
            if (rpg.player.getGold() >= prod2.getBuyingPrice()) {
                int actualGold = rpg.player.getGold() - prod2.getBuyingPrice();
                rpg.player.setGold(actualGold);
                rpg.player.inventory.put(products[1], rpg.player.inventory.getOrDefault(products[1], 0) + 1);
            }
        }
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Tienda");
    }
}