package Models.Locations;

import Controllers.Game;
import Models.Enemy;

public class Combat extends Location {

    private Enemy enemy;
    private int enemyHP;
    public Location happeningIn;
    public boolean givesHP;
    public boolean gameStateChanger;
    public boolean specialReward;

    public Combat(String[] options, Game rpg, Enemy enemy, Location location, Boolean givesHP, Boolean gameStateChanger, Boolean specialReward) {
        super(options, rpg);
        this.enemy = enemy;
        this.enemyHP = enemy.getEnemyHP();
        this.happeningIn = location;
        this.givesHP = givesHP;
        this.gameStateChanger = gameStateChanger;
        this.specialReward = specialReward;
    }

    @Override
    void command1() { //Atacar
        //De player a enemigo
        enemyHP -= rpg.player.attack;

        //De enemigo a player
        int actualHP = rpg.player.getHP() - enemy.getAttack();
        rpg.player.setHp(actualHP);

        if (rpg.player.getHP() <= 0) {
            playerDeath();
        }
        if (rpg.player.getHP() > 0 && enemyHP <= 0) {
            rewardPlayer();
        }
    }

    @Override
    void command2() { //Huir
        rpg.locations.get("Ciudad").mainString = "¡He escapado por los pelos! Debería \n prepararme mejor antes de volver a intentarlo";
        rpg.setActualPlace("Ciudad");

        //Sistema de respawneo
        Plains temp = (Plains) rpg.locations.get("Llanuras");
        temp.enemies.replaceAll((e, v) -> true);
        Forest temp1 = (Forest) rpg.locations.get("Bosque");
        temp1.enemies.replaceAll((e, v) -> true);;
        Forest temp2 = (Forest) rpg.locations.get("Mazmorra1");
        temp2.enemies.replaceAll((e, v) -> true);;
        Forest temp3 = (Forest) rpg.locations.get("Mazmorra2");
        temp3.enemies.replaceAll((e, v) -> true);
    }

    @Override
    void command3() { //Curarse
        if (rpg.player.inventory.get(rpg.items.get(4)) > 0){
            rpg.player.setHp(rpg.player.hp + 60);
        } else if (rpg.player.inventory.get(rpg.items.get(3)) > 0){
            rpg.player.setHp(rpg.player.hp + 30);
        } else {
            rpg.setActualPlace("");
        }
    }

    private void playerDeath() {
        rpg.locations.get("Ciudad").mainString = "¿Qué ha pasado? Me siento adolorido...";
        rpg.setActualPlace("Ciudad");
        rpg.player.setGold(rpg.player.gold - 50);

//        Si queremos ser mala gente podemos respawnear enemigos.
        Plains temp = (Plains) rpg.locations.get("Llanuras");
        temp.enemies.replaceAll((e, v) -> true);
        Forest temp1 = (Forest) rpg.locations.get("Bosque");
        temp1.enemies.replaceAll((e, v) -> true);;
        Forest temp2 = (Forest) rpg.locations.get("Mazmorra1");
        temp2.enemies.replaceAll((e, v) -> true);;
        Forest temp3 = (Forest) rpg.locations.get("Mazmorra2");
        temp3.enemies.replaceAll((e, v) -> true);
    }
    public void rewardPlayer(){

    private void rewardPlayer() {
        rpg.player.setGold(rpg.player.gold + 50);
        if (givesHP){
            rpg.player.hpCap += 50;
        }
        rpg.player.setHp(rpg.player.hpCap);
        for (Item item : (Item) enemy.getRewards()) {
            rpg.player.inventory.put(item, (rpg.player.inventory.get(item))+1);
        }
        if (gameStateChanger){
            rpg.player.gameState += 1;
        }
        if (specialReward){
            rpg.player.setAttack(20);
            rpg.player.inventory.put(rpg.items.get(6),1);
        }
        rpg.setActualPlace(happeningIn);
    }
}
    }
    public void playerDeath(){

    }

