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
    
    public Enemy(String name, double health,double attack,double accuracy,double defense,int mana, Attack... attacks) {
        super(health,attack,defense,accuracy,mana,attacks);
        this.name = name;
    }
    
    public void setModel(Model m){
        this.model = m;
    }
    
    public Attack attack(double enemyHealth) {
        Attack attack = null;
        
        if (attack != null) {
            Effect effect = attack.statusEffects.get(Effect.enumEffect.HEALTH,false);
            attack.statusEffects.add(effect.setQuant(effect.quant * (attackBuff/100)));
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
