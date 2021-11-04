package Models.Locations;

import Controllers.Game;

import java.util.Arrays;

public class Forest extends Location {

    public Forest(String[] options, Game rpg) {
        super(options, rpg);

        System.out.println("Has entrado en el bosque, el hogar de los goblins... Ten cuidado");
    }


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
