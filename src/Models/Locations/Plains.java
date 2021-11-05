package Models.Locations;

import Controllers.Game;
import Models.Enemy;

import java.util.HashMap;

public class Plains extends Location{

    Enemy enemy01;
    Enemy enemy02; //Cuando se defina el constructor de enemy, toca crear dos lobos aqui
    public Plains(String[] options,  Game rpg, Enemy en1, Enemy en2) {
        super(options, rpg);
        this.enemy01 = en1;
        this.enemy02 = en2;
        mainString = "Has entrado en las llanuras, donde las manadas de lobo les gusta cazar... Ten cuidado";
    }

    @Override
    void command1() { //Atacar
        if (rpg.player.gameState == 0){
            if (rpg.enemies.get(enemy01)){
                rpg.setActualPlace("Combate1");
            }
        } else {
            if (enemy02.isAlive){
                rpg.setActualPlace("Combate3");
            }
        }
    }

    @Override
    void command2() { //Avanzar
        if (rpg.player.gameState == 0){
            rpg.setActualPlace("Bosque");
        } else {
            rpg.setActualPlace("Mazmorra");
        }
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Ciudad");
    }
}
