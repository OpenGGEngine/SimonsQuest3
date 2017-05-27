/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ethan Mak
 */
public class Weapon implements Cloneable{
    int mpCost;
    double attackPower;
    Map<Effect, Double> statusEffects;
    double durability;
    String name;
    
    public Weapon(String name, int mpCost, double attackPower, double durability) {
        this.name = name;
        this.mpCost = mpCost;
        this.attackPower = attackPower;
        this.durability = durability;
        statusEffects = new HashMap<>();
    }
    
    public Weapon(String name) {
        this(name, 0, 0, 0);
    }
    
    private Map<Effect, Double> use(double amount) {
        HashMap<Effect, Double> effects = new HashMap<>();
        if (durability == -1) {
            effects.putAll(statusEffects);
            effects.put(Effect.ATTACK, attackPower);
            return effects;
        }
        else if  (durability == 0 || amount > durability)
            return effects;
        durability -= amount;
        effects.putAll(statusEffects);
        effects.put(Effect.ATTACK, attackPower);
        return effects;
    }
    
    public void addEffect(Effect effect, double quant) {
        statusEffects.put(effect, quant);
    }
    
    @Override
    public Weapon clone() {
        Weapon ret = new Weapon(name,mpCost,attackPower,durability);
        ret.statusEffects.putAll(statusEffects);
        return ret;
    }
}
