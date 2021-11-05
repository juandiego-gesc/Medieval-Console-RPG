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
        if (lvl == 1 && enemy01.isAlive){
            rpg.setActualPlace("Combate4");
        } else if(enemy02.isAlive) {
            rpg.setActualPlace("Combate5");
        }
    }

    @Override
    void command2() { //Avanzar
        if (lvl == 1){
            lvl += 1;
            this.mainString = "Has entrado en lo mas profundo de las catacumbas \n Dicen que aquí vive una criatura monstruosa... \nTen cuidado";
        }
    }

    @Override
    void command3() {
        rpg.setActualPlace("Ciudad");
    }
}
