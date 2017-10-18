/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

import java.util.Scanner;

/**
 *
 * @author berne
 */
public class RPGGame {
    
    public void doCombat(Map firstWorld, AndroidSelection chosenAndroid) {

        if (firstWorld.mapGrid[firstWorld.xPlayer][firstWorld.yPlayer] == 2) {
            Combat combat = new Combat();
            Enemy enemy = new Enemy();

            combat.encounterLog(chosenAndroid.androidName); //PRINTS ENCOUNTER INTRODUCTION

            if (combat.playerStart()) { //PLAYER STARTS FIRST
                while ((chosenAndroid.playerAndroid.isAlive() && enemy.isAlive()) || !combat.flee()) {
                    
                    System.out.println("What do you want " + chosenAndroid.androidName + " to do?");
                    System.out.println("[a]ttack");
                    System.out.println("[s]pecical attack (use up 1 power)");
                    System.out.println("[f]lee (attempt)");
                    System.out.print("> ");
                    
                    //WHAT MOVE THE USER WANTS TO USE
                    Scanner userInput = new Scanner(System.in);
                    char attackInput = userInput.nextLine().charAt(0);

                    if (attackInput == 'a') {
                        combat.doPlayerAttack(chosenAndroid.playerAndroid.dmg, enemy.def, enemy.HP, enemy.HP, chosenAndroid.androidName);

                        combat.doEnemyAttack(enemy.dmg, chosenAndroid.playerAndroid.def, chosenAndroid.playerAndroid.HP, chosenAndroid.playerAndroid.HP, chosenAndroid.androidName);
                    } else if (attackInput == 's') {
                        combat.doPlayerSpAttack(chosenAndroid.playerAndroid.dmg, enemy.def, enemy.HP, enemy.HP, chosenAndroid.androidName, chosenAndroid.playerAndroid.power);

                        combat.doEnemyAttack(enemy.dmg, chosenAndroid.playerAndroid.def, chosenAndroid.playerAndroid.HP, chosenAndroid.playerAndroid.HP, chosenAndroid.androidName);
                    } else if (attackInput == 'f') {
                        if (combat.flee() == true) {
                            System.out.println("+ " + chosenAndroid.androidName + " managed to get away!");
                            System.out.println("#===================================================#");
                        } else if (combat.flee() == false) {
                            System.out.println("- " + chosenAndroid.androidName + "'s attempt to flee was unsuccessful.");
                            System.out.println("#===================================================#");
                        }
                    }
                }
            } else if (!combat.playerStart()) { //ENEMY STARTS FIRST
                while ((chosenAndroid.playerAndroid.isAlive() && enemy.isAlive()) || !combat.flee()) {
                    
                    System.out.println("What do you want " + chosenAndroid.androidName + " to do?");
                    System.out.println("[a]ttack");
                    System.out.println("[s]pecical attack (use up 1 power)");
                    System.out.println("[f]lee (attempt)");
                    System.out.print("> ");
                    
                    //WHAT MOVE THE USER WANTS TO USE
                    Scanner userInput = new Scanner(System.in);
                    char attackInput = userInput.nextLine().charAt(0);

                    if (attackInput == 'a') {
                        combat.doEnemyAttack(enemy.dmg, chosenAndroid.playerAndroid.def, chosenAndroid.playerAndroid.HP, chosenAndroid.playerAndroid.HP, chosenAndroid.androidName);

                        combat.doPlayerAttack(chosenAndroid.playerAndroid.dmg, enemy.def, enemy.HP, enemy.HP, chosenAndroid.androidName);
                    } else if (attackInput == 's') {
                        combat.doEnemyAttack(enemy.dmg, chosenAndroid.playerAndroid.def, chosenAndroid.playerAndroid.HP, chosenAndroid.playerAndroid.HP, chosenAndroid.androidName);

                        combat.doPlayerSpAttack(chosenAndroid.playerAndroid.dmg, enemy.def, enemy.HP, enemy.HP, chosenAndroid.androidName, chosenAndroid.playerAndroid.power);
                    } else if (attackInput == 'f') {
                        if (combat.flee() == true) {
                            System.out.println("+ " + chosenAndroid.androidName + " managed to get away!");
                            System.out.println("#===================================================#");
                        } else if (combat.flee() == false) {
                            System.out.println("- " + chosenAndroid.androidName + "'s attempt to flee was unsuccessful.");
                            System.out.println("#===================================================#");
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("+=========================================+");
        System.out.println("|  SPACE EXPLORATION: BY MARK AND WILSON  |");
        System.out.println("+=========================================+");
        
        System.out.println("👏You have landed on a deserted planet with the sole purpose");
        System.out.println("to explore the surroundings. You control a remote");
        System.out.println("controlled bot of your choosing, from the safety of your ship.");
        System.out.println("The ship is low on fuel, you must find some fuel to leave the planet.");
        System.out.println("#=================================================================#");

        //MAKE A CHARACTER
        //CharacterSelection player = new CharacterSelection();
        
        //CHOOSE AN ANDROID
        AndroidSelection chosenAndroid = new AndroidSelection();
        
        System.out.println("MOVEMENT: ");
        System.out.println("[i] FORWARDS");
        System.out.println("[k] BACKWARDS");
        System.out.println("[l] RIGHT");
        System.out.println("[j] LEFT");
        
        //GENERATE THE MAP
        Map firstWorld = new Map();

/*-----------------------------MOVEMENT---------------------------------------*/
        int count = 0;

        for (int i = 0; i < 10; i++) {
            for (int a = 0; a < 10; a++) {
                if (firstWorld.mapGrid[i][a] == 1) {
                    count++;
                    System.out.println(count + ": (" + i + ", " + a + ")");
                }
            }
        }

        boolean move = false;
        
        do {
            Scanner ctrlKey = new Scanner(System.in);
            System.out.print("> ");
            char ctrlMovement = ctrlKey.nextLine().charAt(0);
            
            if ((ctrlMovement == 'i') || (ctrlMovement == 'I')) {
                /*=====FORWARDS=====*/
                if (firstWorld.yPlayer < 10) {
                    firstWorld.yPlayer++;
                    move = true;
                    
                    System.out.println("(" + firstWorld.xPlayer + ", " + firstWorld.yPlayer + ")");
                    
                    try {
                        RPGGame main = new RPGGame();
                        main.doCombat(firstWorld, chosenAndroid);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        
                    }
                    
                    //firstWorld.printMap();
                } else if (firstWorld.yPlayer == 10) {
                    System.out.println("Walking into walls is not recommended.");
                    RPGGame main = new RPGGame();
                    main.doCombat(firstWorld, chosenAndroid);
                } else if (firstWorld.mapGrid[firstWorld.xPlayer][firstWorld.yPlayer] == 1) {
                    System.out.println("You can't travel through boulders.");
                }
            } else if ((ctrlMovement == 'k') || (ctrlMovement == 'K')) {
                /*=====BACKWARDS=====*/
                if (firstWorld.yPlayer > 0) {
                    firstWorld.yPlayer--;
                    move = true;
                    
                    System.out.println("(" + firstWorld.xPlayer + ", " + firstWorld.yPlayer + ")");
                    
                    try {
                        RPGGame main = new RPGGame();
                        main.doCombat(firstWorld, chosenAndroid);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        
                    }
                    
                    //firstWorld.printMap();
                } else if (firstWorld.yPlayer == 0) {
                    System.out.println("Walking into walls is not recommended.");
                    RPGGame main = new RPGGame();
                    main.doCombat(firstWorld, chosenAndroid);
                    move = false;
                } else if (firstWorld.mapGrid[firstWorld.xPlayer][firstWorld.yPlayer] == 1) {
                    System.out.println("You can't travel through boulders.");
                }
            } else if ((ctrlMovement == 'j') || (ctrlMovement == 'J')) {
                /*=====LEFT=====*/
                if (firstWorld.xPlayer > 0) {
                    firstWorld.xPlayer--;
                    move = true;
                    System.out.println("(" + firstWorld.xPlayer + ", " + firstWorld.yPlayer + ")");
                    
                    try {
                        RPGGame main = new RPGGame();
                        main.doCombat(firstWorld, chosenAndroid);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        
                    }
                    
                    //firstWorld.printMap();
                } else if (firstWorld.xPlayer == 0) {
                    System.out.println("Walking into walls is not recommended.");
                    move = false;
                } else if (firstWorld.mapGrid[firstWorld.xPlayer][firstWorld.yPlayer] == 1) {
                    System.out.println("You can't travel through boulders.");
                    RPGGame main = new RPGGame();
                    main.doCombat(firstWorld, chosenAndroid);
                }
            } else if ((ctrlMovement == 'l') || (ctrlMovement == 'L')) {
                /*=====RIGHT=====*/
                if (firstWorld.xPlayer < 10) {
                    firstWorld.xPlayer++;
                    move = true;
                    
                    System.out.println("(" + firstWorld.xPlayer + ", " + firstWorld.yPlayer + ")");
                    try {
                        RPGGame main = new RPGGame();
                        main.doCombat(firstWorld, chosenAndroid);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        
                    }
                    
                    //firstWorld.printMap();
                } else if (firstWorld.xPlayer == 10) {
                    System.out.println("Walking into walls is not recommended.");
                    move = false;
                } else if (firstWorld.mapGrid[firstWorld.xPlayer][firstWorld.yPlayer] == 1) {
                    System.out.println("You can't travel through boulders.");
                    RPGGame main = new RPGGame();
                    main.doCombat(firstWorld, chosenAndroid);
                }
            }
        } while ((firstWorld.xPlayer != 2) || (firstWorld.yPlayer != 10));
        
        System.out.println("You found the fuel! Your bot makes it back to your ship, and you can now safely leave the planet.");
        
        //FOR TESTING PURPOSES, GAME 'ENDS' AT [2][10]
    }
}
