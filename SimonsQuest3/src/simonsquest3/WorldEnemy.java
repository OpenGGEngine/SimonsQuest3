/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.WorldEngine;
import com.opengg.core.math.Quaternionf;
import com.opengg.core.math.Vector3f;
import com.opengg.core.world.collision.AABB;
import com.opengg.core.world.collision.CylinderCollider;
import com.opengg.core.world.components.Component;
import com.opengg.core.world.components.ModelRenderComponent;
import com.opengg.core.world.components.physics.CollisionComponent;
import com.opengg.core.world.components.physics.PhysicsComponent;

/**
 *
 * @author Javier
 */
public class WorldEnemy extends Component{
    public final static float viewdist = 100f;
    ModelRenderComponent model;
    PhysicsComponent physics;
    Enemy stats;
    public WorldEnemy(Enemy enemy){
        stats = enemy;
        model = new ModelRenderComponent(enemy.model);
        physics = new PhysicsComponent();
        physics.addCollider(new CollisionComponent(new AABB(new Vector3f(),10,6,10), new CylinderCollider(1,2)));
        physics.setAbsoluteOffset(true);
        physics.mass = 60f;
        physics.bounciness = 0;
        physics.frictionCoefficient = 0.8f;
        
        this.attach(model);
        this.attach(physics);
    }
    
    @Override
    public void update(float delta){
        if(stats.health <= 0){
            WorldEngine.markForRemoval(this);
            model.setDrawable(null);
            return;
        }
        if(WorldCreator.simon.getPosition().subtract(getPosition()).length() > viewdist)
            return;
        Vector3f movedirection = WorldCreator.simon.getPosition().subtract(getPosition());
        movedirection.y = 0.01f;
        movedirection.normalizeThis();
        setRotationOffset(new Quaternionf(movedirection));
        setPositionOffset(getPositionOffset().addThis(movedirection.multiplyThis(4).multiplyThis(delta)));
    }
}
