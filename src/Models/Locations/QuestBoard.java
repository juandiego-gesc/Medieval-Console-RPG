package Models.Locations;

import Controllers.Game;

public class QuestBoard extends Location{

    public QuestBoard(String[] options, Game rpg) { super(options, rpg); }

    @Override
    void command1() { //Goblin
        rpg.player.gameState = 0;
        rpg.setActualPlace("Llanuras");
//        System.out.println("Estas en la mision del goblin"); //Esto es una prueba
    }

    @Override
    void command2() { //Dragon
        rpg.player.gameState = 1;
        rpg.setActualPlace("Llanuras");
//        System.out.println("Estas en la mision del dragon"); //Esto es una prueba
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Ciudad");
    }
}