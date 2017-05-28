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
    
    public Enemy(String name, double health,double attack,double accuracy, double defense, Weapon... attacks) {
        super(health,attack,defense,accuracy,attacks);
        this.name = name;
    }
    
    public void setModel(Model m){
        this.model = m;
    }
    
    public Weapon attack(double enemyHealth) {
        Weapon attack = null;
        if (attack != null) {
            Effect effect = attack.statusEffects.get(Effect.enumEffect.HEALTH,false);
            attack.statusEffects.add(effect.setQuant(effect.quant * (attackBuff/100)));
        }
        return attack;
    }
    
    @Override
    public Enemy clone(){
        Enemy enemy = new Enemy(name, attackBuff,defenseBuff,accuracy,health);
        enemy.setModel(model);
        for (Weapon attack : attacks) {
            enemy.addAttack(attack.clone());
        }
        return enemy;
    }
}
