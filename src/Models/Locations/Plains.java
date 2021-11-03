package Models.Locations;

import Controllers.Game;

public class Plains extends Location{

    public Plains(String[] options,  Game rpg) {
        super(options, rpg);
        System.out.println("Has entrado en la el las llanuras, donde las manadas de lobo les gusta cazar... Ten cuidado");
        mainString = "A la verga wey, un lobo!";
    }

    @Override
    void command1() {
        System.out.println("Perro HP");
    }

    @Override
    void command2() {
        System.out.println("Pues como dijo Andrea...");
    }

    @Override
    void command3() {
        //volver
        rpg.setActualPlace("Ciudad");
    }
}
