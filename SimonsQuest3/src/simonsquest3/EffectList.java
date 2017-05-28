/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.ArrayList;
import simonsquest3.Effect.enumEffect;

/**
 *
 * @author Ethan Mak
 */
public class EffectList extends ArrayList<Effect>{
    
    public Effect get(enumEffect effect, boolean useOnOneself, boolean onlyForBattle) {
        for (Effect e : this) {
            if (e.stat == effect && e.useOnOneself == useOnOneself && e.onlyForBattle == onlyForBattle)
                return e;
        }
        Effect e = new Effect(effect,0,useOnOneself);
        super.add(e);
        return e;
    }
    
    public Effect get(enumEffect effect, boolean useOnOneself) {
        return get(effect, useOnOneself, false);
    }
    
    @Override
    public boolean add(Effect e) {
        if (e == null)
            throw new NullPointerException("Effect is null");
        Effect ex = get(e.stat, e.useOnOneself);
        if (ex == null)
            return !super.add(ex);
        else {
            ex.useOnOneself = e.useOnOneself;
            ex.quant = e.quant;
        }
        return true;
    }
}
