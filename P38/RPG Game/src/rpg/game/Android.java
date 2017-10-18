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
public abstract class Android{

    protected int dmg;
    protected int def;
    protected int HP = 500;
    protected int power = 3;

    public Android() {
        stats();
    }

    protected int dodge() {
        Random generator = new Random();
        int randNum = generator.nextInt(10);

        return randNum;
    }

    abstract void stats();

//    public int getDMG() { //simply return choosen android's attack value
//        int a;
//        int b;
//        int c;
//        AndroidSelection android = new AndroidSelection();
//        
//        switch (android.androidNum) {
//            case 1: //DMG android
//                AndroidDMG androidDmg = new AndroidDMG();
//                a = androidDmg.dmg;
//                
//                return a;
//            case 2:
//                AndroidDEF androidDef = new AndroidDEF();
//                b = androidDef.dmg;
//                
//                return b;
//            case 3:
//                AndroidJACK androidJack = new AndroidJACK();
//                c = androidJack.dmg;
//                
//                return c;
//            default:
//                break;
//        }
//    }
    
    public boolean isAlive() {
        return HP > 0;
    }
}
