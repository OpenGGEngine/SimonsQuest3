/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.WorldEngine;
import com.opengg.core.math.FastMath;
import com.opengg.core.math.Vector3f;
import com.opengg.core.world.components.Component;

/**
 *
 * @author Ethan Mak
 */
public class EnemySpawner extends Component{
    Enemy enemy;
    public EnemySpawner(Enemy enemy){
        this.enemy = enemy;
    }
    
    public void spawnEnemy(int num){
        WorldEnemy[] newenemies = new WorldEnemy[num];
        for(int i = 0; i < num; i++){
            newenemies[i] = new WorldEnemy(enemy.clone());
            WorldEngine.getCurrent().attach(newenemies[i]);
            newenemies[i].setPositionOffset(getPosition().add(new Vector3f(FastMath.random(50),0,FastMath.random(50))));
        }
    }
    
    public Enemy getEnemy(){
        return enemy;
    }
}
