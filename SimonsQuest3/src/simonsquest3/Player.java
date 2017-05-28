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
    public int money = 100;
    public int mana;
    public int maxMana;
    
    public Player(double health,int mana) {
        super(health,100,100,80);
        items = new HashMap<>();
        money = 100;
        this.mana = mana;
        maxMana = mana;
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
        switch (effect) {
            case CHANGE_MP:
                changeMana((int)quant);
                break;
        }
    }
    
    public void changeMana(int amount) {
        mana = FastMath.clamp(mana, 0, maxMana);
    }
    
    public Weapon waitForChoice() {
        Weapon ret = null;
        Map<Effect,Double> effects = new HashMap<>();
        //wait
        if (ret != null)
            if(isHit())
                effects = ret.use(1);
            else 
                return null;
        
        if (effects.get(Effect.MISSED) == -1)
            return null;
        for(Map.Entry<Effect,Double> effect: effects.entrySet()) {
            useEffect(effect.getKey(), effect.getValue());
        }
        if (ret != null) {
            ret = ret.clone();
            ret.statusEffects.put(Effect.DAMAGE, ret.statusEffects.get(Effect.DAMAGE) * (attackBuff/100));
        }
        return ret;
    }
}

