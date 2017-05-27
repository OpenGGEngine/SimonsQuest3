/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.math.FastMath;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ethan Mak
 */
public class Player extends GeneralEntity{
    public HashMap<Item, Integer> items;
    public int money;
    
    public Player(double health) {
        super(health,100,100);
        items = new HashMap<>();
        money = 0;
    }
    
    public void addItem(Item item) {
        if(items.get(item) == null)
            items.put(item, 1);
        else
            items.put(item, items.get(item) + 1);
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
        Weapon ret = null;
        Map<Effect,Double> effects = new HashMap<>();
        //wait
        for(Map.Entry<Effect,Double> effect: effects.entrySet()) {
            useEffect(effect.getKey(), effect.getValue());
        }
        if (ret != null)
            ret.statusEffects.put(Effect.DAMAGE, ret.statusEffects.get(Effect.DAMAGE) * (attackBuff/100));
        return ret;
    }
}

