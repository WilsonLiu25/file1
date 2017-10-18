/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

import java.util.Random;

/**
 *
 * @author berne
 */
public class Map {
    public int[][] mapGrid;
    
    public int xPlayer;
    public int yPlayer;
    
    private int xCoord;
    private int yCoord;
    
    private Random rand;
    
    public int obstacleCount = 0;
    public int scrapMetalCount = 0;
    public int batteryCount = 0;
    public int enemyCount = 0;
    
    public Map() {
        generateMap();
    }
    
    private void generateMap() {
        xPlayer = 5;
        yPlayer = 0;
        
        mapGrid = new int[10][10];
        
        do {
            generateObstacle();
            if (isGenSuccess(true)) {
                obstacleCount++;
            }
        } while(obstacleCount < 3);
    
        do {
            generateScrapMetal();
            if (isGenSuccess(true)) {
                scrapMetalCount++;
            }
        } while(obstacleCount < 3);
        
        do {
            generateBatteryPacks();
            if (isGenSuccess(true)) {
                batteryCount++;
            }
        } while(obstacleCount < 3);
        
        do {
            generateEncounter();
            if (isGenSuccess(true)) {
                enemyCount++;
            }
        } while (enemyCount < 4);
    }
    
    /*MAKE RANDOM BLOCK EQUAL ONE WHILE BLOCK IS EQUAL TO ZERO*/
    private void generateObstacle() {
        rand = new Random();
        
        int obstX = rand.nextInt(10);
        int obstY = rand.nextInt(10);
                
        isGenSuccess(false);
        
        while ((mapGrid[obstX][obstY] == 0) && (mapGrid[obstX][obstY] != mapGrid[5][0])) {
            mapGrid[obstX][obstY] = 1;
            isGenSuccess(true);
        }
    }
    
    /*MAKE RANDOM BLOCK EQUAL TWO WHILE BLOCK IS EQUAL TO ZERO*/
    private void generateEncounter() {
        rand = new Random();
        int encounterX = rand.nextInt(10);
        int encounterY = rand.nextInt(10);
        
        isGenSuccess(false);
        
        while (mapGrid[encounterX][encounterY] == 0) {
            mapGrid[encounterX][encounterY] = 2;
            isGenSuccess(true);
        }
    }
    
    /*MAKE RANDOM BLOCK EQUAL THREE WHILE BLOCK IS EQUAL TO ZERO*/
    private void generateBatteryPacks() {
        rand = new Random();
        int battX = rand.nextInt(10);
        int battY = rand.nextInt(10);
        
        isGenSuccess(false);
        
        while (mapGrid[battX][battY] == 0) {
            mapGrid[battX][battY] = 3;
            isGenSuccess(true);
        }
    }
    
    /*MAKE RANDOM BLOCK EQUAL FOUR WHILE BLOCK IS EQUAL TO ZERO*/
    private void generateScrapMetal() {
        rand = new Random();
        int scrapX = rand.nextInt(10);
        int scrapY = rand.nextInt(10);
        
        isGenSuccess(false);
        
        while (mapGrid[scrapX][scrapY] == 0) {
            mapGrid[scrapX][scrapY] = 4;
            isGenSuccess(true);
        }
    }
    
    private boolean isGenSuccess(boolean gen) {
        return gen;
    }
    
    private void mapActions() {
        if (mapGrid[xPlayer][yPlayer] == 1) {
            //PLAYER CANNOT BE HERE
        } else if (mapGrid[xPlayer][yPlayer] == 2) {
            //Combat fight = new Combat();
        } else if (mapGrid[xPlayer][yPlayer] == 3) {
            //power++;
        } else if (mapGrid[xPlayer][yPlayer] == 4) {
            //HP++;
        }
    }
    
    
    /*=====FIX THIS=====*/
//    public void printMap() {
//        if(xPlayer > 0 && xPlayer < 10) {
//            if ((mapGrid[xPlayer - 1][yPlayer] == 1) && (xPlayer > 0)) {
//                System.out.println("To your left is a boulder.");
//            } 
//            if ((mapGrid[xPlayer + 1][yPlayer] == 1) && (xPlayer < 10)) {
//                System.out.println("To your right is a boulder.");
//            } 
//            if ((mapGrid[xPlayer][yPlayer + 1] == 1) && (yPlayer < 10)) {
//                System.out.println("A bouder is blocking your path ahead.");
//            }
//            if ((mapGrid[xPlayer][yPlayer - 1] == 1) && (yPlayer > 0)) {
//                System.out.println("A bouder is behind you.");
//            }
//        }
//    }
}
 