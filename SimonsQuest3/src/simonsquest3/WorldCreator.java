/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.RenderEngine;
import com.opengg.core.engine.Resource;
import com.opengg.core.engine.WorldEngine;
import com.opengg.core.math.FastMath;
import com.opengg.core.math.Quaternionf;
import com.opengg.core.math.Vector3f;
import com.opengg.core.model.Model;
import com.opengg.core.model.ModelLoader;
import com.opengg.core.render.light.Light;
import com.opengg.core.render.shader.Program;
import com.opengg.core.render.shader.ShaderController;
import com.opengg.core.render.texture.ArrayTexture;
import com.opengg.core.render.texture.Cubemap;
import com.opengg.core.render.texture.Texture;
import com.opengg.core.world.Camera;
import com.opengg.core.world.Skybox;
import com.opengg.core.world.Terrain;
import com.opengg.core.world.components.FreeFlyComponent;
import com.opengg.core.world.components.LightComponent;
import com.opengg.core.world.components.ModelRenderComponent;
import com.opengg.core.world.components.SunComponent;
import com.opengg.core.world.components.TerrainComponent;
import com.opengg.core.world.components.WaterComponent;
import com.opengg.core.world.components.WorldObject;
import com.opengg.core.world.generators.DiamondSquare;

/**
 *
 * @author Javier
 */
public class WorldCreator {
    public static final int WORLDSIZE = 5000;
    static int enemySpawnCount = 120;
    static TerrainComponent world;
    static SimonComponent simon;
    static FreeFlyComponent fly;
    static Camera arenaCam;
    static WorldObject arena;
    static ModelRenderComponent e1, e2, e3;
    static int day = 0;
    public static void create(){
        ShaderController.loadShader("newterrainfrag", Resource.getShaderPath("newterrain.frag"), Program.FRAGMENT);
        ShaderController.use("mainvert", "newterrainfrag");
        ShaderController.saveCurrentConfiguration("terrain2");
        ShaderController.setTextureLocation("Ka", 1);
        
        world = new TerrainComponent(Terrain.generateProcedural(new DiamondSquare(7,20,20,5.5f), WORLDSIZE/5, WORLDSIZE/5));
        world.setScale(new Vector3f(WORLDSIZE,60,WORLDSIZE));
        world.setPositionOffset(new Vector3f(-(WORLDSIZE/2), 0,-(WORLDSIZE/2)));
        world.setGroundArray(ArrayTexture.get(Resource.getTexturePath("sand.jpg"), Resource.getTexturePath("grass.png"),Resource.getTexturePath("dirt.png"), Resource.getTexturePath("snow.png")));
        world.setBlotmap(world.getTerrain().getHeightmap());
        world.setShader("terrain2");
        world.setName("terrain");
        
        WorldEngine.getCurrent().attach(world);
        world.enableRendering();
        world.enableCollider(); 
        
        WaterComponent water = new WaterComponent(Texture.get(Resource.getTexturePath("water.png")), 1f, 300f);
        WorldEngine.getCurrent().attach(water);
        water.setPositionOffset(new Vector3f(0,200,0));
        WorldEngine.getCurrent().setFloor(200);
        
        fly = new FreeFlyComponent();
        
        SunComponent sun = new SunComponent(Texture.get(Resource.getTexturePath("default.png")), 0, 0.1f);
        WorldEngine.getCurrent().attach(sun);
        
        simon = new SimonComponent();
        simon.use();
        WorldEngine.getCurrent().attach(simon);
        
        arena = new WorldObject();
        arena.setPositionOffset(new Vector3f(0,4000,-3000));
        ModelRenderComponent arenamodel = new ModelRenderComponent(ModelLoader.loadModel(Resource.getModelPath("arena")));
        arenamodel.setScale(new Vector3f(0.015f));
        arena.attach(arenamodel);
        ModelRenderComponent playerview = new ModelRenderComponent(ModelLoader.loadModel(Resource.getModelPath("ct")));
        playerview.setPositionOffset(new Vector3f(-1.3f,0,0));
        playerview.setRotationOffset(new Quaternionf(new Vector3f(0,70,0)));
        arena.attach(playerview);
        e1 = new ModelRenderComponent();
        e1.setPositionOffset(new Vector3f(1f,0,-1));
        e1.setRotationOffset(new Quaternionf(new Vector3f(0,-70,0)));
        e2 = new ModelRenderComponent();
        e2.setPositionOffset(new Vector3f(1.3f,0,0));
        e2.setRotationOffset(new Quaternionf(new Vector3f(0,-70,0)));
        e3 = new ModelRenderComponent();
        e3.setPositionOffset(new Vector3f(2f,0,1));
        e3.setRotationOffset(new Quaternionf(new Vector3f(0,-70,0)));
        arena.attach(e1);
        arena.attach(e2);
        arena.attach(e3);
        WorldEngine.getCurrent().attach(arena);
        
        LightComponent warlight = new LightComponent(new Light(new Vector3f(0,4020,-3000), new Vector3f(1), 300,0));
        warlight.use();
        WorldEngine.getCurrent().attach(warlight);
        
        arenaCam = new Camera();
        arenaCam.setPos(new Vector3f(0,-4002,2995));
        arenaCam.setRot(new Quaternionf(new Vector3f(10,0,0)));
        //RenderEngine.useCamera(arenaCam);
        
        for(int i = 0; i < enemySpawnCount; i++){
            EnemySpawner spawner = new EnemySpawner(EnemyFactory.generateEnemy("stormtrooper"));
            if(i % EnemyFactory.enemycount == 0)
                spawner = new EnemySpawner(EnemyFactory.generateEnemy("stormtrooper"));
            if(i % EnemyFactory.enemycount == 1)
                spawner = new EnemySpawner(EnemyFactory.generateEnemy("ct"));
            if(i % EnemyFactory.enemycount == 2)
                spawner = new EnemySpawner(EnemyFactory.generateEnemy("beaver"));
            if(i % EnemyFactory.enemycount == 3)
                spawner = new EnemySpawner(EnemyFactory.generateEnemy("imposter"));
            if(i % EnemyFactory.enemycount == 4)
                spawner = new EnemySpawner(EnemyFactory.generateEnemy("justinbeaver"));
            if(i % EnemyFactory.enemycount == 5)
                spawner = new EnemySpawner(EnemyFactory.generateEnemy("halo"));
            WorldEngine.getCurrent().attach(spawner);
            boolean validPos = false;
            do{
                spawner.setPositionOffset(new Vector3f(FastMath.random(WORLDSIZE)-WORLDSIZE/2, -300, FastMath.random(WORLDSIZE)-WORLDSIZE/2));
                if(world.getHeightAt(spawner.getPosition()) > 250)
                    validPos = true;
            }while(!validPos);            
            spawner.spawnEnemy(3);
        }       
        RenderEngine.setSkybox(new Skybox(Cubemap.get(Resource.getTexturePath("skybox\\bluecloud")), 4500f));
        WorldEngine.useWorld(WorldEngine.getCurrent());
    }
    
    public static void addEnemyInRing(Model model, int slot){
        if(slot == 1)
            e1.setModel(model);
        if(slot == 2)
            e2.setModel(model);
        if(slot == 3)
            e3.setModel(model);
    }
    
    public static void clearRingEnemies(){
        e1.setDrawable(null);
        e2.setDrawable(null);
        e3.setDrawable(null);
    }
    
    public static void enableBattle(){
        WorldEngine.getCurrent().setEnabled(false);
        RenderEngine.useCamera(arenaCam);
    }
    
    public static void disableBattle(){
        WorldEngine.getCurrent().setEnabled(true);
        simon.use();
    }
}

