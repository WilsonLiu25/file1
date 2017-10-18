/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

/**
 *
 * @author syk2011
 */
public class AndroidJACK extends Android {
    public int dmg = 6;

    @Override
    void stats() {
        dmg = 6;
        def = 6;
    }
  
    public int returnDMG() {
         return dmg;
    }
}
