package simonsquest3;

import com.opengg.core.model.Model;

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
    
    public Enemy(String name, Model model, double health,double attack, double defense, Weapon... attacks) {
        super(health,attack,defense,attacks);
        this.name = name;
        this.model = model;
    }
    
    public Weapon attack(double enemyHealth) {
        Weapon attack = null;
        if (attack != null)
            attack.statusEffects.put(Effect.DAMAGE, attack.statusEffects.get(Effect.DAMAGE) * (defenseBuff/100));
        return attack;
    }
    
    @Override
    public Enemy clone(){
        Enemy enemy = new Enemy(name, model,attackBuff,defenseBuff,health);
        for (Weapon attack : attacks) {
            enemy.addAttack(attack.clone());
        }
        return enemy;
    }
}
