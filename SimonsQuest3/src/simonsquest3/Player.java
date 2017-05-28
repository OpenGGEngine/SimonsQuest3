/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.math.FastMath;
import java.util.HashMap;
import java.util.Map;
import simonsquest3.Effect.enumEffect;

/**
 *
 * @author Ethan Mak
 */
public class Player extends GeneralEntity{
    public HashMap<Item, Integer> items;
    public int money;
    public int mana;
    public int maxMana;
    
    public Player(double health,int mana) {
        super(health,100,100,80);
        items = new HashMap<>();
        money = 0;
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
    public void useEffect(Effect effect) {
        super.useEffect(effect);
        switch (effect.stat) {
            case CHANGE_MP:
                mana = FastMath.clamp(mana + (int)effect.quant, 0, maxMana);
                break;
        }
    }
    
    public Map.Entry<Weapon,Integer> waitForChoice() {
        Weapon ret = null;
        EffectList effects = new EffectList();
        int target = 1;
        //wait
        if (ret != null)
            if(isHit())
                effects = ret.use(1);
            else 
                return null;
        
        if (effects.get(enumEffect.MISSED,false).quant == -1)
            return null;
        for(Effect effect: effects) {
            if(effect.useOnOneself)
                useEffect(effect);
        }
        if (ret != null) {
            ret = ret.clone();
            Effect e = ret.statusEffects.get(enumEffect.HEALTH, false);
            ret.statusEffects.add(e.setQuant(e.quant * (attackBuff/100)));
        }
        return new HashMap.SimpleEntry<>(ret,target);
    }
}

