package simonsquest3;

import com.opengg.core.model.ModelLoader;
import com.opengg.core.world.components.Component;
import com.opengg.core.world.components.ModelRenderComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ethan Mak
 */
public class Enemy extends Component{
    String name;
    ModelRenderComponent model;
    Weapon[] attacks;
    double health;
    
    public Enemy(String name, String fileName) {
        health = 0;
        attacks = new Weapon[4];
        this.name = name;
        model = new ModelRenderComponent(ModelLoader.loadModel(fileName));
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
}
