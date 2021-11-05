package Models.Locations;

import Controllers.Game;
import Models.Items.Item;

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
        if (venta){
            int actualGold = rpg.player.getGold() + forSale[0].getSellingPrice() * rpg.player.inventory.get(forSale[0]);
            rpg.player.setGold(actualGold);
            rpg.player.inventory.put(forSale[0], 0);
        } else {
            int actualGold = rpg.player.gold - products[0].getBuyingPrice();
            rpg.player.setGold(actualGold);
            rpg.player.inventory.put(products[0], rpg.player.inventory.getOrDefault(products[0], 1));
        }
    }

    @Override
    void command2() { //Vender/Comprar segundo elemento
        if (venta){
            int actualGold = rpg.player.getGold() + forSale[1].getSellingPrice() * rpg.player.inventory.get(forSale[1]);
            rpg.player.setGold(actualGold);
            rpg.player.inventory.put(forSale[1], 0);
        } else {
            int actualGold = rpg.player.getGold() - products[1].getBuyingPrice();
            rpg.player.setGold(actualGold);
            rpg.player.inventory.put(products[1], rpg.player.inventory.getOrDefault(products[1], 0) + 1);
        }
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Tienda");
    }
}