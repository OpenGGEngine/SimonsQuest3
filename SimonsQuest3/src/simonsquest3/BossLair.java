/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.Resource;
import com.opengg.core.math.Vector3f;
import com.opengg.core.model.ModelLoader;
import com.opengg.core.world.collision.AABB;
import com.opengg.core.world.collision.CylinderCollider;
import com.opengg.core.world.components.Component;
import com.opengg.core.world.components.ModelRenderComponent;
import com.opengg.core.world.components.physics.CollisionComponent;

/**
 *
 * @author Javier
 */
public class BossLair extends Component{
    CollisionComponent collider;
    ModelRenderComponent render;
    Enemy boss;
    
    public BossLair(Enemy enemy, Vector3f pos){
        this.boss = enemy;
        this.render = new ModelRenderComponent(ModelLoader.loadModel(Resource.getModelPath("lair")));
        render.setScale(new Vector3f(20));
        collider = new CollisionComponent(new AABB(new Vector3f(), 100,40,100), new CylinderCollider(40,90));
        this.pos = pos;
        attach(collider);
        attach(render);
    }
}
