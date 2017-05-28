package simonsquest3;

import com.opengg.core.model.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import simonsquest3.Effect.enumEffect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ethan Mak
 */
public class Enemy extends GeneralEntity implements Cloneable{
    String name;
    Model model;
    
    public Enemy(String name, double health,double attack,double accuracy,double defense,int mana, Attack... attacks) {
        super(health,attack,defense,accuracy,mana,attacks);
        this.name = name;
    }
    
    public void setModel(Model m){
        this.model = m;
    }
    
    public Attack attack(Player enemy) {
        Attack attack = null;
        double healthPercent = health/maxHealth;
        double enemyHealthPercent = enemy.health/enemy.maxHealth;
        HashMap<enumEffect,List<Attack>> attackEnemy = new HashMap<>();
        HashMap<enumEffect,List<Attack>> selfEffects = new HashMap<>();
        for(enumEffect ef : enumEffect.values()) {
            attackEnemy.put(ef,new ArrayList<>());
            selfEffects.put(ef,new ArrayList<>());
        }
        for (Attack a : attacks) {
            if (a.attackPower > 0)
                attackEnemy.get(enumEffect.HEALTH).add(a);
            for (Effect e : a.statusEffects) {
                if (e.useOnOneself)
                    selfEffects.get(e.stat).add(a);
                else
                    attackEnemy.get(e.stat).add(a);
            }
        }
        if (healthPercent < 0.10) {
            attack = maxAttack(enumEffect.HEALTH,-1,attackEnemy,true);
        }
        else {
            double val = (healthPercent*0.53) + (enemyHealthPercent * 0.27) + (defenseBuff/200 * 0.1) + (attackBuff/200 * 0.1);
            if(val > 0.9) {
                attack = maxAttack(enumEffect.HEALTH,-1,attackEnemy,false);
            }
            if (val > 0.8 && attack == null) {
                attack = maxAttack(enumEffect.ATTACK,1,selfEffects,true);
            }
            if (val > 0.7 && attack == null) {
                attack = maxAttack(enumEffect.DEFENSE,1,selfEffects,true);
            }
            if (val > 0.3 && attack == null) {
                attack = maxAttack(enumEffect.HEALTH,-1,attackEnemy,true);
            }
            else if (attack == null) {
                attack = maxAttack(enumEffect.HEALTH,1,selfEffects,true);
            }
        }
        if (attack != null) {
            Effect effect = attack.statusEffects.get(Effect.enumEffect.HEALTH,false);
            attack.statusEffects.add(effect.setQuant(effect.quant * (attackBuff/100)));
        }
        return attack;
    }
    
    private Attack maxAttack(enumEffect ef, int mult, HashMap<enumEffect,List<Attack>> map,boolean useAcc) {
        double maxDamage = Double.MIN_VALUE;
        Attack attack = null;
        for (Attack a : map.get(enumEffect.HEALTH)) {
            if (!useAcc) {
                if ((a.attackPower*mult) > maxDamage) {
                    maxDamage = a.attackPower;
                    attack = a;
                }
            } else {
                if ((a.attackPower*mult)*0.75 + a.accuracy*0.25 > maxDamage) {
                    maxDamage = a.attackPower;
                    attack = a;
                }
            }
        }
        return attack;
    }
    
    @Override
    public Enemy clone(){
        Enemy enemy = new Enemy(name, attackBuff,defenseBuff,accuracy,health,mana);
        enemy.setModel(model);
        for (Attack attack : attacks) {
            enemy.addAttack(attack.clone());
        }
        return enemy;
    }
}
