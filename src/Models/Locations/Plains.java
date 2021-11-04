package Models.Locations;

import Controllers.Game;

public class Plains extends Location{

    public Plains(String[] options,  Game rpg) {
        super(options, rpg);
        mainString = "Has entrado en la el las llanuras, donde las manadas de lobo les gusta cazar... Ten cuidado";
    }

    @Override
    void command1() {

    }

    @Override
    void command2() {

    }

    @Override
    void command3() {
        //volver
        rpg.setActualPlace("Ciudad");
    }
}
