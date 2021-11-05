package Models.Locations;

import Controllers.Game;

public class City extends Location{

    public City(String[] options, Game rpg) {
        super(options, rpg);
        mainString = "Estas en la ciudad y tienes tres opciones. \n ¿Qué harás?";
    }

    @Override
    void command1() { //Tienda
//      Esto es una prueba del sistema  System.out.println("Pa la tienda");
        this.rpg.setActualPlace("Tienda");
    }

    @Override
    void command2() { //Herrero
//      Esto es una prueba del sistema  System.out.println("Pal Herrero");
        this.rpg.setActualPlace("Herrero");
    }

    @Override
    void command3() { //Tablero
//      Esto es una prueba del sistema  System.out.println("Pa las plains");
        this.rpg.setActualPlace("Tablero");
    }
}
