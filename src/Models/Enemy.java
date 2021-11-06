package Models;

import Models.Items.Item;


public class Enemy {
    int enemyHp;
    int[] enemyAttackRange;
    String displayText;
    Item reward;
    public Boolean isAlive;

    public Enemy(int enemyHp, int[] enemyAttack, String displayText, Item reward) {
        this.enemyHp = enemyHp;
        this.enemyAttackRange = enemyAttack;
        this.displayText = displayText;
        this.reward = reward;
        this.isAlive = true;
    }

    public int getEnemyHp(){
        return enemyHp;
    }
    public int[] getEnemyAttackRange(){
        return enemyAttackRange;
    }
    public Item getReward(){
        return reward;
    }
    public String getDisplayText(){
        return displayText;
    }

}
