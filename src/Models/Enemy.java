package Models;

import java.util.ArrayList;

public class Enemy extends Player {
    int enemyHp, enemyAttack[] = new int [2];
    String displayTest;
    ArrayList reward = new ArrayList();

    public int getEnemyHp(){
        return enemyHp;
    }
    public int[] getEnemyAttack(){
        return enemyAttack;
    }
    public ArrayList getReward(){
        return reward;
    }
    public String getDisplayText(){
        return displayTest;
    }

}
