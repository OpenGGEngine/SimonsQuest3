package simonsquest3;

import com.opengg.core.engine.Resource;
import com.opengg.core.math.FastMath;
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
        Enemy ret = new Enemy(name,0,100,100,100,10,null,0);
        switch (name) {
            case "beaver":
                ret.health = 0;
                ret.name = "Beaver";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("bite"));
                ret.addAttack(AttackFactory.generateAttack("rear"));
                ret.addAttack(AttackFactory.generateAttack("dam"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("beaver")));
                ret.moneydrop = FastMath.random(50);
                break;
            case "justinbeaver":
                ret.health = 0;
                ret.name = "Justin Beaver";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("bite"));
                ret.addAttack(AttackFactory.generateAttack("sing"));
                ret.addAttack(AttackFactory.generateAttack("fans"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("justinbeaver")));
                ret.moneydrop = FastMath.random(50);
                break;
            case "ct":
                ret.health = 0;
                ret.name = "Counter Terrorist";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("csite"));
                ret.addAttack(AttackFactory.generateAttack("spinbot"));
                ret.addAttack(AttackFactory.generateAttack("p90"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("ct")));
                ret.moneydrop = FastMath.random(50);
                break;
            case "halo":
                ret.health = 0;
                ret.name = "Master Chief";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("shield"));
                ret.addAttack(AttackFactory.generateAttack("banshee"));
                ret.addAttack(AttackFactory.generateAttack("cortana"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("halo")));
                ret.moneydrop = FastMath.random(50);
                break;
            case "imposter":
                ret.health = 0;
                ret.name = "Maya the Imposter";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("sue"));
                ret.addAttack(AttackFactory.generateAttack("jazz"));
                ret.addAttack(AttackFactory.generateAttack("sting"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("Maya")));
                ret.moneydrop = FastMath.random(50);
                break;
            case "stormtrooper":
                ret.health = 0;
                ret.name = "Stormtrooper";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("miss"));
                ret.addAttack(AttackFactory.generateAttack("headbutt"));
                ret.addAttack(AttackFactory.generateAttack("order66"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("stormtrooper")));
                ret.moneydrop = FastMath.random(50);
                break;
            case "barry":
                ret.health = 250;
                ret.name = "Barry B. Benson";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("miss"));
                ret.addAttack(AttackFactory.generateAttack("headbutt"));
                ret.addAttack(AttackFactory.generateAttack("order66"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("barry")));
                ret.moneydrop = 250;
                break;
            case "anakin":
                ret.health = 250;
                ret.name = "Anakin";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("miss"));
                ret.addAttack(AttackFactory.generateAttack("headbutt"));
                ret.addAttack(AttackFactory.generateAttack("order66"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("anakin")));
                ret.moneydrop = 250;
                break;
            case "obiwan":
                ret.health = 250;
                ret.name = "Obi Wan";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("miss"));
                ret.addAttack(AttackFactory.generateAttack("headbutt"));
                ret.addAttack(AttackFactory.generateAttack("order66"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("obiwan")));
                ret.moneydrop = 250;
                break;
            case "shrek":
                ret.health = 250;
                ret.name = "Shrek";
                ret.accuracy = 80;
                ret.addAttack(AttackFactory.generateAttack("miss"));
                ret.addAttack(AttackFactory.generateAttack("headbutt"));
                ret.addAttack(AttackFactory.generateAttack("order66"));
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("shrek")));
                ret.moneydrop = 250;
                break;
        }
        return ret;
    }
    
    public static Enemy generateBoss() {
        return null;
    }
}
