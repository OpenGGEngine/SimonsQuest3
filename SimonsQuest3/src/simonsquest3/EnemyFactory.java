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
    
    public static Enemy generateEnemy(String name) {
        Enemy ret = new Enemy(name,0,100,100);
        switch (name) {
            case "beaver":
                ret.health = 0;
                ret.name = "Beaver";
                ret.addAttack(WeaponFactory.generateAttack("bite"));
 
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("beaver")));
                break;
            case "ct":
                ret.health = 0;
                ret.name = "Counter Terrorist";

                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("ct")));
                break;
            case "halo":
                ret.health = 0;
                ret.name = "Master Chief";
 
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("halo")));
                break;
            case "imposter":
                ret.health = 0;
                ret.name = "Maya the Imposter";

                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("Maya")));
                break;
            case "stormtrooper":
                ret.health = 0;
                ret.name = "Stormtrooper";
  
                ret.setModel(ModelLoader.loadModel(Resource.getModelPath("stormtrooper")));
                break;
        }
        return ret;
    }
}
