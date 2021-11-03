package Models.Locations;

import Controllers.Game;

public class City extends Location{

    public City(String[] options, Game rpg) {
        super(options, rpg);
        mainString = "Estas en la ciudad y tienes tres opciones. \n ¿Qué harás?";
    }

    @Override
    void command1() {
        //Models.Locations.Tienda
        //this.rpg.setActualPlace("tienda");
        System.out.println("Pa la tienda");
        // esto podria modificar una variable en el manager que determine el lugar
        //de pronto un hashmap
    }

    @Override
    void command2() {
        //Herrero
        System.out.println("Pal Herrero");
        //this.rpg.setActualPlace("Herrero");
    }

    @Override
    void command3() {
        //Ir a Mision
        System.out.println("Pa las plains");
        this.rpg.setActualPlace("Plains");
    }
}
