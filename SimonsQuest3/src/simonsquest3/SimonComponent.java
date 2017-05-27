/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simonsquest3;

import com.opengg.core.engine.BindController;
import com.opengg.core.engine.Resource;
import com.opengg.core.math.Quaternionf;
import com.opengg.core.math.Vector3f;
import com.opengg.core.model.ModelLoader;
import com.opengg.core.world.Action;
import com.opengg.core.world.ActionType;
import com.opengg.core.world.Actionable;
import com.opengg.core.world.collision.AABB;
import com.opengg.core.world.collision.BoundingBox;
import com.opengg.core.world.collision.CylinderCollider;
import com.opengg.core.world.components.CameraComponent;
import com.opengg.core.world.components.Component;
import com.opengg.core.world.components.ModelRenderComponent;
import com.opengg.core.world.components.UserControlComponent;
import com.opengg.core.world.components.WorldObject;
import com.opengg.core.world.components.physics.CollisionComponent;
import com.opengg.core.world.components.physics.PhysicsComponent;

/**
 *
 * @author Javier
 */
public class SimonComponent extends Component implements Actionable{
    private final PhysicsComponent playerphysics;
    private final UserControlComponent controller;
    private final CameraComponent camera;
    private final ModelRenderComponent player;
    
    Vector3f control = new Vector3f();
    Vector3f controlrot = new Vector3f();
    Vector3f currot = new Vector3f();
    WorldObject head;
    float speed = 20;
    float rotspeed = 30;
    
    public SimonComponent(){
        head = new WorldObject();
        camera = new CameraComponent();
        camera.setPositionOffset(new Vector3f(0,3,7));
        head.setPositionOffset(new Vector3f(0,2f,0));
        head.setAbsoluteOffset(true);
        controller = new UserControlComponent();
        playerphysics = new PhysicsComponent();
        playerphysics.addCollider(new CollisionComponent(new AABB(new Vector3f(),10,6,10), new CylinderCollider(1,2)));
        playerphysics.setAbsoluteOffset(true);
        playerphysics.mass = 60f;
        playerphysics.bounciness = 0;
        playerphysics.frictionCoefficient = 0.8f;
        player = new ModelRenderComponent(ModelLoader.loadModel(Resource.getModelPath("simon")));
        player.setScale(new Vector3f(2));
        player.setRotationOffset(new Quaternionf(new Vector3f(0,180,0)));
        
        head.attach(camera);
        attach(player);
        attach(controller);
        attach(playerphysics);
        attach(head);
    }
    
    @Override
    public void update(float delta){
        currot.x += controlrot.x * rotspeed * delta;
        currot.y += controlrot.y * rotspeed * delta;
        currot.z += controlrot.z * rotspeed * delta;
                
        this.setRotationOffset(new Quaternionf(new Vector3f(0,currot.y,currot.z)));      
        Vector3f movement = new Vector3f(control.x  * speed, 0 ,control.z  *speed);
        movement = getRotation().transform(movement);
        
        head.setRotationOffset(new Quaternionf(new Vector3f(currot.x,0,0)));
        
        playerphysics.velocity.x = movement.x;
        playerphysics.velocity.z = movement.z;
            
        if((control.y == 1) && playerphysics.grounded)
            playerphysics.velocity.y += 5;
        
    }
    
    @Override
    public void onAction(Action action) {
        if(action.type == ActionType.PRESS){
            switch(action.name){
                case "forward":
                    control.z -= 1;
                    break;
                case "backward":
                    control.z += 1;
                    break;
                case "left":
                    control.x -= 1;
                    break;
                case "right":
                    control.x += 1;
                    break;
                case "up":
                    control.y += 1;
                    break;
                case "lookright":
                    controlrot.y -= 1;
                    break;
                case "lookleft":
                    controlrot.y += 1;
                    break;
                 case "lookup":
                    controlrot.x += 1;
                    break;
                case "lookdown":
                    controlrot.x -= 1;
                    break;
            }
        }else{
            switch(action.name){
                case "forward":
                    control.z += 1;
                    break;
                case "backward":
                    control.z -= 1;
                    break;
                case "left":
                    control.x += 1;
                    break;
                case "right":
                    control.x -= 1;
                    break;
                case "up":
                    control.y -= 1;
                    break;
                case "lookright":
                    controlrot.y += 1;
                    break;
                case "lookleft":
                    controlrot.y -= 1;
                    break;
                case "lookup":
                    controlrot.x -= 1;
                    break;
                case "lookdown":
                    controlrot.x += 1;
                    break;
            }
        }
    }
    
    public void use(){
        BindController.addController(controller);
        camera.use();
    }
    
}
