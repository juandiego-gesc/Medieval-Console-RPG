package Models.Locations;

import Controllers.Game;
import Models.Enemy;

import java.util.HashMap;

public class Plains extends Location{

    HashMap <Enemy, Boolean> enemies = new HashMap<>();
    Enemy enemy01 = new Enemy();
    Enemy enemy02 = new Enemy(); //Cuando se defina el constructor de enemy, toca crear dos lobos aqui
    public Plains(String[] options,  Game rpg) {
        super(options, rpg);
        enemies.put(enemy01, true);
        enemies.put(enemy02, true);
        mainString = "Has entrado en las llanuras, donde las manadas de lobo les gusta cazar... Ten cuidado";
    }

    @Override
    void command1() { //Atacar
        if (rpg.player.gameState == 0){
            if (enemies.get(enemy01)){
                rpg.setActualPlace("Combate1");
            }
        } else {
            if (enemies.get(enemy02)){
                rpg.setActualPlace("Combate3");
            }
        }
    }

    @Override
    void command2() { //Avanzar
        if (rpg.player.gameState == 0){
            rpg.setActualPlace("Bosque");
        } else {
            rpg.setActualPlace("Mazmorra1");
        }
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Ciudad");
    }
}
