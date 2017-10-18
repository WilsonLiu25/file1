/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

import java.util.Random;
import java.lang.Math;

/**
 *
 * @author syk2011
 */
public class Combat {

    Random rand;

    public Combat() {
        super();

    }

    public void combatStats(AndroidSelection player, Enemy enemy) {
        rand = new Random();
        boolean playerStart = false;

        //PLAYER ANDROID STATS
        int playerAttackDmg = player.playerAndroid.dmg;
        int playerAttackDef = player.playerAndroid.def;
        int playerPower = player.playerAndroid.power;
        int playerHP = player.playerAndroid.HP;
        int currentPlayerHP = 500;
        String androidName = player.androidName;

        //ENEMY STATS
        int enemyAttackDmg = enemy.dmg;
        int enemyAttackDef = enemy.def;
        final int enemyHP = enemy.HP;
        int currentEnemyHP = enemyHP;

//        //-----------------SIMULATING TURN BASED COMBAT-----------------
//        if (playerStart) {
//            do {
//                doPlayerAttack(playerAttackDmg, enemyAttackDef, enemyHP, currentEnemyHP, androidName);
//   
//                doEnemyAttack(enemyAttackDmg, playerAttackDef, playerHP, currentPlayerHP, androidName);
//
//            } while (player.playerAndroid.isAlive() && enemy.isAlive());
//        } else if (!playerStart) {
//            do {
//                doEnemyAttack(enemyAttackDmg, playerAttackDef, playerHP, currentPlayerHP, androidName);
//                doPlayerAttack(playerAttackDmg, enemyAttackDef, enemyHP, currentEnemyHP, androidName);
//            } while (playerStart);
//
//        }
//        //-----------------SIMULATING TURN BASED COMBAT-----------------
    }

    private int playerAttack(int dmg) {
        rand = new Random();
        int randDmg = rand.nextInt(10);
        int finalDmg = dmg * randDmg;

        return finalDmg;
    }

    private int playerDefense(int def) {
        rand = new Random();
        int randDef = rand.nextInt(10);
        int finalDef = def * randDef;

        return finalDef;
    }

    private int playerSpecialAttack(int dmg, int pow) {
        int baseAttackValue = playerAttack(dmg);
        int finalSpecial = baseAttackValue + 10;

        pow--;

        return finalSpecial;
    }

    public boolean flee() {
        boolean fleeSuccess = false;

        rand = new Random();
        int escapeChance = rand.nextInt(100);

        if (escapeChance >= 79) {
            fleeSuccess = true;
        }

        return fleeSuccess;
    }
    //----------------------------------------------------------------

    private int enemyAttack(int dmg) {
        rand = new Random();
        int randDmg = rand.nextInt(10);
        int finalDmg = dmg * randDmg;

        return finalDmg;

    }

    private int enemyDefence(int def) {
        rand = new Random();
        int randDef = rand.nextInt(10);
        int finalDef = def * randDef;

        return finalDef;
    }

    public void doPlayerAttack(int playerDmg, int enemyDef, int enemyHP, int currentEnemyHP, String androidName) {
        int playerAttack = playerAttack(playerDmg);
        int enemyDefense = enemyDefence(enemyDef);

        int actualAttack = playerAttack - enemyDefense;
        actualAttack = Math.abs(actualAttack); //THE DIFFERENCE of the 2 numbers

        int newHP = enemyHP - actualAttack;
        currentEnemyHP = newHP; //UPDATES ENEMY HP

        System.out.println("+ " + androidName + " deals " + actualAttack + " damage to the Cronenberg! ");
        System.out.println("+ The Cronenberg's now has " + currentEnemyHP + "HP left");
        System.out.println("#===================================================#");
    }

    public void doEnemyAttack(int enemyDmg, int playerDefence, int playerHP, int currentPlayerHP, String androidName) {
        int enemyAttack = enemyAttack(enemyDmg);
        int playerDef = playerDefense(playerDefence);

        int actualAttack = enemyDmg - playerDefence;
        actualAttack = Math.abs(actualAttack);//THE DIFFERENCE of the 2 numbers

        int newHP = playerHP - actualAttack;
        currentPlayerHP = newHP; //UPDATES

        //CHOOSE THE WORD TO DESCRIBE Cronenberg ATTACK
        String stringAttack = " ";
        rand = new Random();
        int stringAtt = rand.nextInt(1);
        if (stringAtt == 0) {
            stringAttack = "lunges";
        } else if (stringAtt == 1) {
            stringAttack = "swipes";
        }

        System.out.println("- Cronenberg " + stringAttack + " at " + androidName + " dealing " + actualAttack + " damage!");
        System.out.println("- Your HP is now " + currentPlayerHP + " !");
        System.out.println("#===================================================#");
    }

    public void doPlayerSpAttack(int playerSpDmg, int enemyDef, int enemyHP, int currentEnemyHP, String androidName, int power) {
        int playerAttack = playerSpecialAttack(playerSpDmg, power);
        int enemyDefense = enemyDefence(enemyDef);

        int actualAttack = playerAttack - enemyDefense;
        actualAttack = Math.abs(actualAttack); //THE DIFFERENCE of the 2 numbers

        int newHP = enemyHP - actualAttack;
        power--;
        currentEnemyHP = newHP; //UPDATES ENEMY HP

        System.out.println("- Consuming 1 power...");
        System.out.println("+ " + androidName + "'s body illuminates with a light blue light as it charges its plasma beam at the center of its chest ");
        System.out.println("+ " + androidName + " fires its plasma beam at the Cronenberg! dealing " + actualAttack + " damage!");
        System.out.println("+ The Cronenberg's now has " + currentEnemyHP + "HP left");
        System.out.println("- You now have " + power + " remaining");
        System.out.println("#===================================================#");
    }

    public void encounterLog(String androidName) {
        System.out.println("#===================================================#");
        System.out.println("! " + androidName + " has been ambushed by a Cronenberg!");
        System.out.println("! Battle start!...");
    }

    public boolean playerStart() { //DETERMINE WHO STARTS FIRST
        boolean playerStart = false;
        Random rn = new Random();
        int startDice = rn.nextInt(100);
        
        if (startDice >= 50) {
            playerStart = true;
        }
        else if (startDice < 50) {
            playerStart = false;
        }
        
        return false;
    }
    
}