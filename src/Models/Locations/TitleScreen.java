package Models.Locations;

import Controllers.Game;

import java.awt.event.ActionEvent;

public class TitleScreen extends Location{
    public TitleScreen(String[] options, Game rpg) {
        super(options, rpg);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();
        switch (choice){
            case "Start":command1();break;
            case "Continue":command2();break;
        }
    }

    @Override
    void command1() {
        System.out.println("Start");
        rpg.startGame();
        rpg.setActualPlace("Ciudad");
    }

    @Override
    void command2() {
        System.out.println("Continue");
        rpg.startGame();
        rpg.loadPlayerData();
        rpg.setActualPlace("Ciudad");
    }

    @Override
    void command3() {

    }
}
