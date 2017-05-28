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
import java.util.Random;

/**
 *
 * @author Ethan Mak
 */
public abstract class GeneralEntity {
    public double health;
    public double maxHealth;
    public List<Attack> attacks;
    public double attackBuff;
    public double defenseBuff;
    public double accuracy;
    public int mana;
    public int maxMana;
    private Random rand;
    
    protected GeneralEntity(double health,double attack,double defense,double accuracy,int mana, Attack... attacks) {
        this.health = health;
        this.maxHealth = health;
        this.attacks = new ArrayList<>();
        this.accuracy = accuracy;
        this.attackBuff = attack;
        this.defenseBuff = defense;
        this.attacks.addAll(Arrays.asList(attacks));
        this.mana = mana;
        this.maxMana = mana;
        this.rand = new Random();
    }
    
    public void addAttack(Attack attack) {
        this.attacks.add(attack);
    }
    
    public void useEffect(Effect effect) {
        switch (effect.stat) {
            case HEALTH:
                if (effect.quant < 0)
                    damage(effect.quant);
                else 
                    health = FastMath.clamp(health + effect.quant, 0, maxHealth);
                break;
            case ATTACK:
                attackBuff = FastMath.clamp(attackBuff + effect.quant,0,300);
                break;
            case DEFENSE:
                defenseBuff = FastMath.clamp(defenseBuff + effect.quant,0,300);
                break;
            case ACCURACY:
                accuracy = FastMath.clamp(accuracy + effect.quant,0,100);
                break;
            case CHANGE_MP:
                mana = FastMath.clamp(mana + (int)effect.quant, 0, maxMana);
                break;
        }
    }
    
    public void damage(double amount) {
        health = FastMath.clamp(health + amount/(defenseBuff/100.0), 0, maxHealth);
    }
    
    protected boolean isHit() {
        return rand.nextInt() % 100 < accuracy;
    }
}   
