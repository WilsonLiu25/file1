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
public class AndroidDMG extends Android{


    @Override
    void stats() {
        dmg = 8;
        def = 4;
    }
    
    public int returnDMG() {
         return dmg;
    }
    
}
