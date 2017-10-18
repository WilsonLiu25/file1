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
public class AndroidDEF extends Android{
    public int dmg = 4;

    @Override
    void stats() {
        dmg = 4;
        def = 8;
    }
    
    public int returnDMG() {
         return dmg;
    }
    
}
