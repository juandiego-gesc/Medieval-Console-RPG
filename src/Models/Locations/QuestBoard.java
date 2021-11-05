package Models.Locations;

import Controllers.Game;

public class QuestBoard extends Location{

    public QuestBoard(String[] options, Game rpg) {
        super(options, rpg);
        this.mainString = "Estás en el tablero de misiones. \n" +
                "Te recomendamos iniciar con los goblins \n" +
                "¿Cuál quieres tomar?\n Pdt: Recuerda guardar tu juego con el boton de la esquina inferior derecha.";
    }

    @Override
    void command1() { //Goblin
        rpg.player.gameState = 0;
        rpg.locations.get("Llanuras").mainString = "Has entrado en las llanuras. \nLas manadas de lobos cazan aquí, ten cuidado.";
        rpg.setActualPlace("Llanuras");
//        System.out.println("Estas en la mision del goblin"); //Esto es una prueba
    }

    @Override
    void command2() { //Dragon
        rpg.player.gameState = 1;
        rpg.locations.get("Llanuras").mainString = "Has entrado en las llanuras. \nLas manadas de lobos cazan aquí, ten cuidado.";
        rpg.setActualPlace("Llanuras");
//        System.out.println("Estas en la mision del dragon"); //Esto es una prueba
    }

    @Override
    void command3() { //Volver
        rpg.setActualPlace("Ciudad");
    }
}