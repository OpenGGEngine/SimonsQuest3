/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.math.FastMath;
import java.util.HashMap;

/**
 *
 * @author Ethan Mak
 */
public class Player extends GeneralEntity{
    public HashMap<Item, Integer> items;
    public double attackBuff;
    public double defenseBuff;
    public int money;
    
    public Player(double health) {
        super(health);
        items = new HashMap<>();
        attackBuff = 100;
        defenseBuff = 100;
        money = 0;
    }
    
    public void addItem(Item item) {
        if(items.get(item) == null)
            items.put(item, 1);
        else
            items.put(item, items.get(item) + 1);
    }
    
    @Override
    public void damage(double amount) {
        health = FastMath.clamp(health - amount/(defenseBuff/100), 0, maxHealth);
    }
    
    @Override
    public void useEffect(Effect effect, double quant) {
        super.useEffect(effect, quant);
        switch(effect) {
            case ATTACK:
                attackBuff += quant;
                break;
            case DEFENSE:
                defenseBuff += quant;
                break;
        }
    }
    
    public Weapon waitForChoice() {
        return null;
    }
}

