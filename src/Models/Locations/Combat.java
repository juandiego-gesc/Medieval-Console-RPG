package Models.Locations;

import Controllers.Game;
import Models.Enemy;
import Models.Items.Item;
import Models.Items.Weapon;

import java.util.Random;

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
        this.enemyHP = enemy.getEnemyHp();
        this.happeningIn = location;
        this.givesHP = givesHP;
        this.gameStateChanger = gameStateChanger;
        this.specialReward = specialReward;
        this.mainString = enemy.getDisplayText();
    }

    @Override
    void command1() { //Atacar
        Random rand = new Random();
        //De player a enemigo
        enemyHP -= rpg.player.getAttack();

        //De enemigo a player
        rpg.player.setHp(rpg.player.getHp() -(rand.nextInt(((enemy.getEnemyAttackRange()[1] - enemy.getEnemyAttackRange()[0]) + 1) + enemy.getEnemyAttackRange()[0])));

        if (rpg.player.getHp() <= 0) {
            playerDeath();
        }
        if (rpg.player.getHp() > 0 && enemyHP <= 0) {
            rewardPlayer();
        }
    }

    @Override
    void command2() { //Huir
        rpg.locations.get("Ciudad").mainString = "¡He escapado por los pelos! Debería \n prepararme mejor antes de volver a intentarlo";
        rpg.setActualPlace("Ciudad");

        //Sistema de respawneo
        for (Enemy enemy:rpg.enemies.values()) {
            enemy.isAlive = true;
        }
    }

    @Override
    void command3() { //Curarse
        Item potionLvl1 = rpg.items.get(1);
        Item potionLvl2 = rpg.items.get(2);
        if (rpg.player.inventory.getOrDefault(potionLvl2, 0) > 0) {
            rpg.player.heal(60);
            rpg.player.inventory.put(potionLvl2, rpg.player.inventory.get(potionLvl2) - 1);
        } else if (rpg.player.inventory.getOrDefault(potionLvl1,0) > 0) {
            rpg.player.heal(30);
            rpg.player.inventory.put(potionLvl1, rpg.player.inventory.get(potionLvl1) - 1);
        }
    }

    private void playerDeath() {
        rpg.locations.get("Ciudad").mainString = "Te han encontrado desplomado en medio de la " +
                "nada y te han traido a la ciudad...\n" +
                "Intenta mejorar tu equipo y conseguir pociones";
        rpg.setActualPlace("Ciudad");
        rpg.player.setGold(rpg.player.gold - 50);
        rpg.player.setHp(25);

//        Si queremos ser mala gente podemos respawnear enemigos.
        for (Enemy enemy:rpg.enemies.values()) {
            enemy.isAlive = true;
        }
    }

    private void rewardPlayer() {
        rpg.player.setGold(rpg.player.gold + 50);
        if (givesHP) {
            rpg.player.hpCap += 50;
        }
        rpg.player.setHp(rpg.player.hpCap);

        rpg.player.inventory.put(enemy.getReward(), (rpg.player.inventory.getOrDefault(enemy.getReward(),0)) + 1);

        if (gameStateChanger) {
            rpg.player.gameState += 1;
        }
        if (specialReward) {
            Weapon newSword = (Weapon) rpg.items.get(6);
            rpg.player.setAttack(newSword.getDamage());
            rpg.player.inventory.put(rpg.items.get(6), 1);
        }

        enemy.isAlive = false;

        happeningIn.mainString = "¡Felicitaciones! Has vencido.";
        rpg.setActualPlace(happeningIn);
    }

}

