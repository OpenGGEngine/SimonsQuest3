/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.WorldEngine;
import com.opengg.core.world.collision.Collision;
import com.opengg.core.world.components.physics.CollisionComponent;
import com.opengg.core.world.components.triggers.Trigger;
import com.opengg.core.world.components.triggers.TriggerInfo;
import com.opengg.core.world.components.triggers.Triggerable;
import java.util.List;
import simonsquest3.gui.GUIMaster;

/**
 *
 * @author Javier
 */
public class BattleController implements Triggerable{

    @Override
    public void onTrigger(Trigger source, TriggerInfo info) {
        if(source instanceof CollisionComponent){
            List<Collision> data = (List<Collision>)info.data;
            if(data.isEmpty())
                return;
            Collision temp = data.get(0);
            if(temp.other.parent.parent instanceof WorldEnemy){
                if(temp.thiscollider.parent.parent instanceof SimonComponent){
                    Battle b = new Battle(SimonsQuest3.p);
                    b.addEnemies(((WorldEnemy)temp.other.parent.parent).stats);
                    WorldCreator.addEnemyInRing(((WorldEnemy)temp.other.parent.parent).model.getModel(), 1);
                    WorldCreator.enableBattle();
                }
            }else if(temp.other.parent.parent instanceof SimonComponent){
                if(temp.thiscollider.parent.parent instanceof WorldEnemy){
                    Battle b = new Battle(SimonsQuest3.p);
                    b.addEnemies(((WorldEnemy)temp.thiscollider.parent.parent).stats);
                    WorldCreator.addEnemyInRing(((WorldEnemy)temp.thiscollider.parent.parent).model.getModel(), 1);
                    WorldCreator.enableBattle();
                }
            }
            
            if(temp.other.parent instanceof TownComponent){
                GUIMaster.town.setEnabled(true);
                WorldEngine.getCurrent().setEnabled(false);
            }else if(temp.thiscollider.parent instanceof TownComponent){
                GUIMaster.town.setEnabled(true);
                WorldEngine.getCurrent().setEnabled(false);
            }
            
            if(temp.other.parent instanceof BossLair){
                Battle b = new Battle(SimonsQuest3.p);
                b.addEnemies(((BossLair)temp.other.parent).boss);
                WorldCreator.addEnemyInRing(((BossLair)temp.other.parent).boss.model, 2);
                WorldCreator.enableBattle();
            }else if(temp.thiscollider.parent instanceof BossLair){
                Battle b = new Battle(SimonsQuest3.p);
                b.addEnemies(((BossLair)temp.thiscollider.parent).boss);
                WorldCreator.addEnemyInRing(((BossLair)temp.thiscollider.parent).boss.model, 2);
                WorldCreator.enableBattle();
            }
        }
    }

    @Override
    public void onSubscribe(Trigger trigger) {
        
    }
}
