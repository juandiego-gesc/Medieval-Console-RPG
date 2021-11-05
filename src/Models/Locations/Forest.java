package Models.Locations;

import Controllers.Game;
import Models.Enemy;

public class Forest extends Location {

    Enemy enemy01;

    public Forest(String[] options, Game rpg, Enemy en1) {
        super(options, rpg);
        this.enemy01 = en1;
        this.mainString = "Has entrado en el bosque, el hogar de los goblins... \n Ten cuidado";
    }


    @Override
    void command1() { //Atacar
        if (enemy01.isAlive) {
            rpg.setActualPlace("Combate2");
        }
    }

    @Override
    void command2() { //Avanzar
        rpg.setActualPlace("Ciudad");
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Ciudad");
    }
}
