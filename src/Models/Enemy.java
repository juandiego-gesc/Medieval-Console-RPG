package Models;

import Models.Items.Item;

import java.util.ArrayList;

public class Enemy {
    int enemyHp;
    int[] enemyAttackRange = new int[2];
    String displayText;
    ArrayList<Item> reward = new ArrayList<>();

    public Enemy(int enemyHp, int[] enemyAttack, String displayText, ArrayList<Item> reward) {
        this.enemyHp = enemyHp;
        this.enemyAttackRange = enemyAttack;
        this.displayText = displayText;
        this.reward = reward;
    }

    public int getEnemyHp(){
        return enemyHp;
    }
    public int[] getEnemyAttackRange(){
        return enemyAttackRange;
    }
    public ArrayList getReward(){
        return reward;
    }
    public String getDisplayText(){
        return displayText;
    }

}
