/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.ConsoleListener;
import com.opengg.core.engine.GGConsole;
import com.opengg.core.engine.RenderEngine;
import com.opengg.core.engine.UserCommand;
import com.opengg.core.engine.WorldEngine;
import com.opengg.core.math.Vector3f;

/**
 *
 * @author Javier
 */
public class SimonConsole implements ConsoleListener{

    @Override
    public void onConsoleInput(UserCommand s) {
        if(s.command.equalsIgnoreCase("spawn")){
            if(s.argCount > 0){
                WorldEnemy enemy = new WorldEnemy(EnemyFactory.generateEnemy(s.args[0]));
                enemy.setPositionOffset(RenderEngine.getCurrentCamera().getPos().add(new Vector3f(10,0,0)));
                WorldEngine.getCurrent().attach(enemy);
                System.out.println("Spawned a" + s.args[0]);
            }  
        }
        
        if(s.command.equalsIgnoreCase("noclip")){
            if(RenderEngine.getCurrentCamera() == WorldCreator.simon.camera.camera){
                GGConsole.log("Enabled noclip");
                WorldCreator.fly.use();
            }else{
                GGConsole.log("Disabled noclip");
                WorldCreator.simon.use();
            }
        }
    }
    
}
