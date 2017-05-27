/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ethan Mak
 */
public class Item {
    String name;
    Map<Effect, Double> effects;
    public Item(String name,Map.Entry<Effect,Double>... allEffects) {
        this.name = name;
        effects = new HashMap<>();
        for (Map.Entry<Effect,Double> effect : allEffects) {
            effects.put(effect.getKey(),effect.getValue());
        }
    }
    
    public void addEffect(Effect effect, double quant) {
        effects.put(effect, quant);
    }
}