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
public class Weapon {
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
    
    private double use(double amount) {
        if (durability == -1)
            return attackPower;
        else if  (durability == 0)
            return -1;
        durability -= amount;
        return attackPower;
    }
    
    public void addEffect(Effect effect, double quant) {
        statusEffects.put(effect, quant);
    }
}
