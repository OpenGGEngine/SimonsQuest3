package simonsquest3;

import com.opengg.core.engine.Resource;
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
    public static int enemycount = 6;
    public static Enemy generateEnemy(String name) {
        Enemy ret = new Enemy(name,0,100,100,100,10);
        switch (name) {
            case "beaver":
                ret.health = 0;
                ret.name = "Beaver";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("bite"));
                ret.addAttack(AttackFactory.generateAttack("rear"));
                ret.addAttack(AttackFactory.generateAttack("dam"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("beaver")));
                break;
            case "justinbeaver":
                ret.health = 0;
                ret.name = "Justin Beaver";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("bite"));
                ret.addAttack(AttackFactory.generateAttack("sing"));
                ret.addAttack(AttackFactory.generateAttack("fans"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("justinbeaver")));
                break;
            case "ct":
                ret.health = 0;
                ret.name = "Counter Terrorist";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("csite"));
                ret.addAttack(AttackFactory.generateAttack("spinbot"));
                ret.addAttack(AttackFactory.generateAttack("p90"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("ct")));
                break;
            case "halo":
                ret.health = 0;
                ret.name = "Master Chief";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("shield"));
                ret.addAttack(AttackFactory.generateAttack("banshee"));
                ret.addAttack(AttackFactory.generateAttack("cortana"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("halo")));
                break;
            case "imposter":
                ret.health = 0;
                ret.name = "Maya the Imposter";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("sue"));
                ret.addAttack(AttackFactory.generateAttack("jazz"));
                ret.addAttack(AttackFactory.generateAttack("sting"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("Maya")));
                break;
            case "stormtrooper":
                ret.health = 0;
                ret.name = "Stormtrooper";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("miss"));
                ret.addAttack(AttackFactory.generateAttack("headbutt"));
                ret.addAttack(AttackFactory.generateAttack("order66"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("stormtrooper")));
                break;
        }
        return ret;
    }
    
    public static Enemy generateBoss() {
        return null;
    }
}
