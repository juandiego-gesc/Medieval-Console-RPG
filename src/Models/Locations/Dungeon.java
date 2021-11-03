package Models.Locations;

import Controllers.Game;

public class Dungeon extends Location{

    public Dungeon(String[] options,  Game rpg) {
        super(options, rpg);
        System.out.println("Has entrado en las catacumbas, abran muchos enemigos por aquí... Ten cuidado");}

    @Override
    void command1() {

    }

    @Override
    void command2() {

    }

    @Override
    void command3() {

    }
}
