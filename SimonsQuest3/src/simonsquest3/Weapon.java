/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import simonsquest3.Effect.enumEffect;

/**
 *
 * @author Ethan Mak
 */
public class Weapon implements Cloneable{
    int mpCost;
    double attackPower;
    EffectList statusEffects;
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
        statusEffects = new EffectList();
        rand = new Random();
    }
    
    public Weapon(String name) {
        this(name, 0, 0, 0, 0);
    }
    
    public EffectList use(double amount) {
        return use(amount, false);
    }
    
    public EffectList use(double amount, boolean skip) {
        EffectList effects = new EffectList();
        if (durability == -1) {
            effects.addAll(statusEffects);
            effects.add(new Effect(enumEffect.HEALTH, -attackPower,false));
            if (!skip)
                effects.add(new Effect(enumEffect.CHANGE_MP, (double)-mpCost,true));
            return effects;
        }
        else if  (durability == 0 || amount > durability)
            return effects;
        durability -= amount;
        if (rand.nextInt() % 100 >= accuracy) {
            effects.add(new Effect(enumEffect.MISSED, (double)-1, false));
            return effects;
        }
        effects.addAll(statusEffects);
        effects.add(new Effect(enumEffect.HEALTH, -attackPower, false));
        return effects;
    }
    
    public void addEffect(Effect effect) {
        statusEffects.add(effect);
    }
    
    @Override
    public Weapon clone() {
        Weapon ret = new Weapon(name,mpCost,attackPower,durability,accuracy);
        ret.statusEffects.addAll(statusEffects);
        return ret;
    }
}
