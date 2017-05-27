/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.RenderEngine;
import com.opengg.core.engine.Resource;
import com.opengg.core.engine.WorldEngine;
import com.opengg.core.math.Vector3f;
import com.opengg.core.render.texture.ArrayTexture;
import com.opengg.core.render.texture.Cubemap;
import com.opengg.core.render.texture.Texture;
import com.opengg.core.world.Skybox;
import com.opengg.core.world.Terrain;
import com.opengg.core.world.components.FreeFlyComponent;
import com.opengg.core.world.components.SunComponent;
import com.opengg.core.world.components.TerrainComponent;
import com.opengg.core.world.components.WaterComponent;
import com.opengg.core.world.generators.DiamondSquare;

/**
 *
 * @author Javier
 */
public class WorldCreator {
    public static void create(){
        TerrainComponent world = new TerrainComponent(Terrain.generateProcedural(new DiamondSquare(7,20,20,5.5f), 900, 900));
        world.setScale(new Vector3f(800,10,800));
        world.setPositionOffset(new Vector3f(-400, 0,-400));
        world.setGroundArray(ArrayTexture.get(Resource.getTexturePath("grass.png"), Resource.getTexturePath("snow.png"),Resource.getTexturePath("dirt.png"),"C:/res/smhd/road.png"));
        world.setBlotmap(Texture.get("C:/res/blendMap.png"));
        WorldEngine.getCurrent().attach(world);
        world.enableRendering();
        world.enableCollider(); 
        
        WaterComponent water = new WaterComponent(Texture.get(Resource.getTexturePath("water.png")), 1f, 100f);
        WorldEngine.getCurrent().attach(water);
        water.setPositionOffset(new Vector3f(0,50,0));
        
        FreeFlyComponent freefly = new FreeFlyComponent();
        freefly.use();
        WorldEngine.getCurrent().attach(freefly);
        
        SunComponent sun = new SunComponent(Texture.get(Resource.getTexturePath("default.png")), 0, 0.01f);
        WorldEngine.getCurrent().attach(sun);
        
        RenderEngine.setSkybox(new Skybox(Cubemap.get(Resource.getTexturePath("skybox\\bluecloud")), 1500f));
        WorldEngine.useWorld(WorldEngine.getCurrent());
    }
}
