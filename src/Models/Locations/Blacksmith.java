package Models.Locations;

import Controllers.Game;

public class Blacksmith extends Location {

    public Blacksmith(String[] options, Game rpg) {
        super(options, rpg);
        this.mainString = "Has entrado a la forja.\n" +
                "¿Qué deseas mejorar?";
    }

    @Override
    void command1() { //Mejorar arma
        if (rpg.player.getGold() > 150) {
            rpg.player.setGold(rpg.player.getGold() - 150);
            rpg.player.setAttack(rpg.player.getAttack() + 20);
        }
    }

    @Override
    void command2() { //Mejorar armadura
        if (rpg.player.getGold() > 100) {
            rpg.player.setGold(rpg.player.getGold() - 100);
            rpg.player.hpCap += 20;
            rpg.player.setHp(rpg.player.hpCap);
        }
    }

    @Override
    void command3() {//Volver
        rpg.setActualPlace("Ciudad");
    }
}
