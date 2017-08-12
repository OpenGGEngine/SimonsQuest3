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
    public Battle curbattle;
    
    @Override
    public void onTrigger(Trigger source, TriggerInfo info) {
        if(source instanceof CollisionComponent){
            List<Collision> data = (List<Collision>)info.data;
            if(data.isEmpty())
                return;
            Collision temp = data.get(0);
            if(temp.other.getParent().getParent() instanceof WorldEnemy){
                if(temp.thiscollider.getParent().getParent() instanceof SimonComponent){
                    Battle b = new Battle(SimonsQuest3.p);
                    b.addEnemies(((WorldEnemy)temp.other.getParent().getParent()).stats);
                    b.init();
                    curbattle = b;
                    WorldCreator.addEnemyInRing(((WorldEnemy)temp.other.getParent().getParent()).model.getModel(), 1);
                    WorldCreator.enableBattle();
                }
            }else if(temp.other.getParent().getParent() instanceof SimonComponent){
                if(temp.thiscollider.getParent().getParent() instanceof WorldEnemy){
                    Battle b = new Battle(SimonsQuest3.p);
                    b.addEnemies(((WorldEnemy)temp.thiscollider.getParent().getParent()).stats);
                    b.init();
                    curbattle = b;
                    WorldCreator.addEnemyInRing(((WorldEnemy)temp.thiscollider.getParent().getParent()).model.getModel(), 1);
                    WorldCreator.enableBattle();
                }
            }
            
            if(temp.other.getParent() instanceof TownComponent){
                GUIMaster.town.setEnabled(true);
                WorldEngine.getCurrent().setEnabled(false);
            }else if(temp.thiscollider.getParent() instanceof TownComponent){
                GUIMaster.town.setEnabled(true);
                WorldEngine.getCurrent().setEnabled(false);
            }
            
            if(temp.other.getParent() instanceof BossLair){
                if(((BossLair)temp.other.getParent()).boss.health <= 0){return;};
                Battle b = new Battle(SimonsQuest3.p);
                b.addEnemies(((BossLair)temp.other.getParent()).boss);
                b.init();
                curbattle = b;
                WorldCreator.addEnemyInRing(((BossLair)temp.other.getParent()).boss.model, 2);
                WorldCreator.enableBattle();
            }else if(temp.thiscollider.getParent() instanceof BossLair){
                if(((BossLair)temp.thiscollider.getParent()).boss.health <= 0){return;};
                Battle b = new Battle(SimonsQuest3.p);
                b.addEnemies(((BossLair)temp.thiscollider.getParent()).boss);
                b.init();
                curbattle = b;
                WorldCreator.addEnemyInRing(((BossLair)temp.thiscollider.getParent()).boss.model, 2);
                WorldCreator.enableBattle();
            }
        }
    }

    @Override
    public void onSubscribe(Trigger trigger) {
        
    }
    
    public void update(){
        if(curbattle != null)
            curbattle.update();
    }
}
