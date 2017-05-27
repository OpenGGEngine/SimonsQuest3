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
    
    public Enemy(String name, Model model, double health, Weapon... attacks) {
        super(health, attacks);
        this.name = name;
        this.model = model;
    }
    
    public void addAttack(Weapon attack) {
        this.attacks.add(attack);
    }
    
    public Weapon attack(double enemyHealth) {
        return null;
    }
    
    @Override
    public Enemy clone(){
        Enemy enemy = new Enemy(name, model,health);
        for (Weapon attack : attacks) {
            enemy.addAttack(attack.clone());
        }
        return enemy;
    }
}
