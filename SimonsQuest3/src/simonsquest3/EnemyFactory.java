package simonsquest3;

import com.opengg.core.model.ModelLoader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ethan Mak
 */
public class EnemyFactory {
    
    public static Enemy generateEnemy(String name, String fileName) {
        Enemy ret = new Enemy(name, ModelLoader.loadModel(fileName),0,100,100);
        switch (name) {
            case "beaver":
                ret.health = 0;
                ret.name = "Beaver";
                ret.addAttack(WeaponFactory.generateAttack("bite"));
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                break;
            case "ct":
                ret.health = 0;
                ret.name = "Counter Terrorist";
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                break;
            case "halo":
                ret.health = 0;
                ret.name = "Master Chief";
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                break;
            case "imposter":
                ret.health = 0;
                ret.name = "Maya the Imposter";
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                break;
            case "stormtrooper":
                ret.health = 0;
                ret.name = "Stormtrooper";
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                ret.addAttack(null);
                break;
        }
        return ret;
    }
    
    public static WorldEnemy generateWorldEnemy(String name, String fileName) {
        return new WorldEnemy(EnemyFactory.generateEnemy(name, fileName));
    }
}
