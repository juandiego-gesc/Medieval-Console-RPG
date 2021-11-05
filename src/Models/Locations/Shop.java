package Models.Locations;

import Controllers.Game;

public class Shop extends Location{

    public Shop(String[] options, Game rpg) { super(options, rpg); }

    @Override
    void command1() { //Comprar
        ShopMenu temp = (ShopMenu) rpg.locations.get("MenuTienda");
        temp.venta = false;
        temp.options = new String[]{"Poción LVL1", "Poción LVL2", "Volver"};
        temp.mainString = "";//Aqui tiene que ir el cuadro ese de tienda, eso no lo hago yo
        rpg.setActualPlace("MenuTienda");
    }

    @Override
    void command2() { //Vender
        ShopMenu temp = (ShopMenu) rpg.locations.get("MenuTienda");
        temp.venta = true;
        temp.options = new String[]{"Piel de Lobo", "Carne", "Volver"};
        temp.mainString = "";//Aqui tiene que ir el cuadro ese de tienda, eso no lo hago yo
        rpg.setActualPlace("MenuTienda");
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Ciudad");
    }
}
