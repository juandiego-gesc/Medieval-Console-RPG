package Models.Locations;

import Controllers.Game;
import Models.Enemy;

public class Dungeon extends Location{

    Enemy enemy01;
    Enemy enemy02;
    int lvl;
    public Dungeon(String[] options,  Game rpg, String mainText, Enemy en1, Enemy en2) {
        super(options, rpg);
        this.lvl = 1;

        this.mainString = "Has entrado a las catacumbas. \n Hay muchos enemigos aquí, ten cuidado.";
        this.enemy01 = en1;
        this.enemy02 = en2;

    }

    @Override
    void command1() {
        if (lvl == 1){
            rpg.setActualPlace("Combate4");
        } else {
            rpg.setActualPlace("Combate5");
        }
    }

    @Override
    void command2() {

    }

    @Override
    void command3() {
        rpg.setActualPlace("Ciudad");
    }
}
