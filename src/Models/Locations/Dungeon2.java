package Models.Locations;

import Controllers.Game;

public class Dungeon2 extends Location {
    public Dungeon2(String[] options,  Game rpg) {
        super(options, rpg);
        System.out.println("Has entrado en las catacumbas, dicen que aquí vive una criatura monstruosa... Ten cuidado");}

    @Override
    void command1() {
        mainString = "CHUPELO DRAGON HPTA... DEVUELVE A MI CHICA PIROBO";
    }

    @Override
    void command2() {
        mainString = "Esta marikita solo puede con fuego";
    }

    @Override
    void command3() {
        rpg.setActualPlace("Ciudad");
    }
}
