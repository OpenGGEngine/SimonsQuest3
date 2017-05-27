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
public class Enemy{
    String name;
    Model model;
    Weapon[] attacks;
    double health;
    
    public Enemy(String name, Model model) {
        health = 0;
        attacks = new Weapon[4];
        this.name = name;
        this.model = model;
    }
    
    public void setAttack(Weapon attack, int place) {
        if (place > 3 || place < 0) {
            return;
        }
        attacks[place] = attack;
    }
    
    public Weapon attack(double enemyHealth) {
        return null;
    }
    
    public Enemy cloneEnemy(){
        Enemy enemy = new Enemy(name, model);
        return enemy;
    }
}
