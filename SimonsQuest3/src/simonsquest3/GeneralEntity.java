/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.math.FastMath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ethan Mak
 */
public abstract class GeneralEntity {
    public double health;
    public double maxHealth;
    public List<Weapon> attacks;
    public double attackBuff;
    public double defenseBuff;
    
    protected GeneralEntity(double health,double attack, double defense, Weapon... attacks) {
        this.health = health;
        this.maxHealth = health;
        this.attacks = new ArrayList<>();
        this.attackBuff = attack;
        this.defenseBuff = defense;
        this.attacks.addAll(Arrays.asList(attacks));
    }
    
    public void addAttack(Weapon attack) {
        this.attacks.add(attack);
    }
    
    public void useEffect(Effect effect, double quant) {
        switch (effect) {
            case HEALTH:
                restoreHealth(quant);
                break;
        }
    }
    
    public void damage(double amount) {
        health = FastMath.clamp(health - amount/(defenseBuff/100), 0, maxHealth);
    }
    
    public void restoreHealth(double amount) {
        health = FastMath.clamp(health + amount, 0, maxHealth);
    }
}   
