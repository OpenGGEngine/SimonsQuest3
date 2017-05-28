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
public class TownComponent extends Component{
    ModelRenderComponent visual;
    CollisionComponent collider;
    
    public TownComponent(Vector3f pos){
        this.setPositionOffset(pos);
        visual = new ModelRenderComponent(ModelLoader.loadModel(Resource.getModelPath("town")));
        visual.setScale(new Vector3f(0.015f,0.2f,0.015f));
        collider = new CollisionComponent(new AABB(new Vector3f(), 200,40,200), new CylinderCollider(100,40));
        attach(collider);
        attach(visual);
    }
}
