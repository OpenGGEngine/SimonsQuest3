/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.math.Vector3f;
import com.opengg.core.world.components.physics.CollisionComponent;
import com.opengg.core.world.components.physics.PhysicsComponent;
import com.opengg.core.world.components.triggers.Trigger;
import com.opengg.core.world.components.triggers.TriggerInfo;
import com.opengg.core.world.components.triggers.Triggerable;

/**
 *
 * @author Javier
 */
public class BattleController implements Triggerable{

    @Override
    public void onTrigger(Trigger source, TriggerInfo info) {
        System.out.println("Negr");
        if(source instanceof CollisionComponent){
            if(((CollisionComponent)source).parent instanceof PhysicsComponent){
                if(((PhysicsComponent)((CollisionComponent)source).parent).parent instanceof WorldEnemy){
                    WorldEnemy enemy = (WorldEnemy)((PhysicsComponent)((CollisionComponent)source).parent).parent;
                    Battle b = new Battle(SimonsQuest3.p);
                    b.addEnemies(enemy.stats);
                    enemy.setPositionOffset(WorldCreator.arena.getPosition().add(new Vector3f(1.3f,0,0)));
                    WorldCreator.enableBattle();
                }
            }
        }
    }

    @Override
    public void onSubscribe(Trigger trigger) {
        
    }
    
}
