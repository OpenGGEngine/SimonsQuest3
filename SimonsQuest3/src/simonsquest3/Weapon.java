/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Ethan Mak
 */
public class Weapon implements Cloneable{
    int mpCost;
    double attackPower;
    Map<Effect, Double> statusEffects;
    double durability;
    int accuracy;
    String name;
    Random rand;
    
    public Weapon(String name, int mpCost, double attackPower, double durability, int accuracy) {
        this.name = name;
        this.mpCost = mpCost;
        this.attackPower = attackPower;
        this.durability = durability;
        this.accuracy = accuracy;
        statusEffects = new HashMap<>();
        rand = new Random();
    }
    
    public Weapon(String name) {
        this(name, 0, 0, 0, 0);
    }
    
    public Map<Effect, Double> use(double amount) {
        return use(amount, false);
    }
    
    public Map<Effect, Double> use(double amount, boolean skip) {
        HashMap<Effect, Double> effects = new HashMap<>();
        if (durability == -1) {
            effects.putAll(statusEffects);
            effects.put(Effect.DAMAGE, attackPower);
            if (!skip)
                effects.put(Effect.CHANGE_MP, (double)-mpCost);
            return effects;
        }
        else if  (durability == 0 || amount > durability)
            return effects;
        durability -= amount;
        if (rand.nextInt() % 100 < accuracy) {
            effects.put(Effect.MISSED, (double)-1);
            return effects;
        }
        effects.putAll(statusEffects);
        effects.put(Effect.DAMAGE, attackPower);
        return effects;
    }
    
    public void addEffect(Effect effect, double quant) {
        statusEffects.put(effect, quant);
    }
    
    @Override
    public Weapon clone() {
        Weapon ret = new Weapon(name,mpCost,attackPower,durability,accuracy);
        ret.statusEffects.putAll(statusEffects);
        return ret;
    }
}
