package rpg.game;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tcw3892
 */
import java.util.Random;

public class RandomNum {
    public RandomNum() {
        
    }
    
    public int roll10() {
        Random generator = new Random();
        
        int randNum = generator.nextInt(10) + 1;
        
        return randNum;
    }
    
    public int rollDamage() {
        Random generator = new Random();
        
        int damage = generator.nextInt(8) + 1;
        
        return damage;
    }
    
    public int rollBlock() {
        Random generator = new Random();
        
        int block = generator.nextInt(8) + 1;
        
        return block;
    }
    
    //can make more generates for different number spans 
}
