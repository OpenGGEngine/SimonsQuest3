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
import com.opengg.core.model.ModelLoader;
import com.opengg.core.render.shader.Program;
import com.opengg.core.render.shader.ShaderController;
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
    static TerrainComponent world;
    public static void create(){
        ShaderController.loadShader("newterrainfrag", Resource.getShaderPath("newterrain.frag"), Program.FRAGMENT);
        ShaderController.use("mainvert", "newterrainfrag");
        ShaderController.saveCurrentConfiguration("terrain2");
        ShaderController.setTextureLocation("Ka", 1);
        
        world = new TerrainComponent(Terrain.generateProcedural(new DiamondSquare(7,20,20,5.5f), 1500, 1500));
        world.setScale(new Vector3f(9000,60,9000));
        world.setPositionOffset(new Vector3f(-4500, 0,-4500));
        world.setGroundArray(ArrayTexture.get(Resource.getTexturePath("sand.jpg"), Resource.getTexturePath("grass.png"),Resource.getTexturePath("dirt.png"), Resource.getTexturePath("snow.png")));
        world.setBlotmap(world.getTerrain().getHeightmap());
        world.setShader("terrain2");
        world.setName("terrain");
        
        WorldEngine.getCurrent().attach(world);
        world.enableRendering();
        world.enableCollider(); 
        
        WaterComponent water = new WaterComponent(Texture.get(Resource.getTexturePath("water.png")), 1f, 100f);
        WorldEngine.getCurrent().attach(water);
        water.setPositionOffset(new Vector3f(0,180,0));
        WorldEngine.getCurrent().setFloor(180);
        
        FreeFlyComponent freefly = new FreeFlyComponent();
        //freefly.use();
        WorldEngine.getCurrent().attach(freefly);
        
        SunComponent sun = new SunComponent(Texture.get(Resource.getTexturePath("default.png")), 0, 0.1f);
        WorldEngine.getCurrent().attach(sun);
        
        SimonComponent simon = new SimonComponent();
        simon.use();
        WorldEngine.getCurrent().attach(simon);
        
        EnemySpawner spawner = new EnemySpawner(new Enemy("stormtrooper", ModelLoader.loadModel(Resource.getModelPath("stormtrooper")),10));
        WorldEngine.getCurrent().attach(spawner);
        spawner.spawnEnemy(10);
        
        RenderEngine.setSkybox(new Skybox(Cubemap.get(Resource.getTexturePath("skybox\\bluecloud")), 1500f));
        WorldEngine.useWorld(WorldEngine.getCurrent());
    }
}
