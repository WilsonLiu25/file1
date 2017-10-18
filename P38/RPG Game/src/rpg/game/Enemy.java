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
public class Enemy {
    protected int dmg = 5;
    protected int def = 5;
    protected int HP = 150;
    
    
    public Enemy() {
        super();
    }

    public boolean isAlive() {
        return HP > 0;
    }
}
