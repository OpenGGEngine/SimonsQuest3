/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import com.opengg.core.engine.Resource;
import com.opengg.core.gui.GUI;
import com.opengg.core.gui.GUIGroup;
import com.opengg.core.gui.GUIItem;
import com.opengg.core.gui.GUITexture;
import com.opengg.core.io.input.keyboard.Key;
import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.io.input.keyboard.KeyboardListener;
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.texture.Texture;
import com.opengg.core.world.Action;
import com.opengg.core.world.Actionable;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Warren
 */
public class GUIMaster implements KeyboardListener{
    static float xonscreen = -1;
    public static GUIGroup town = new GUIGroup(new Vector2f());
    public static GUIItem simon = new GUITexture(Texture.get(Resource.getTexturePath("/gui/simon.png")),new Vector2f(-1,-1f),new Vector2f(0.25f,0.75f));
    public static GUIItem simonstatue = new GUITexture(Texture.get(Resource.getTexturePath("/gui/simon.png")),new Vector2f(0,-0.4f),new Vector2f(0.25f,0.75f));
    public static void init(){
      GUI.root.addItem("town", town);
      
      town.addItem("townbackground", new GUITexture(Texture.get(Resource.getTexturePath("/gui/townbackground.png")),new Vector2f(-1,-1),new Vector2f(2,2)));
      town.addItem("simons", simonstatue);
      town.addItem("simon", simon);
      
    }

    @Override
    public void keyPressed(int key) {
        System.out.println("sd");
        if(key == Key.KEY_LEFT){
            xonscreen+=0.01f;
            town.getItem("simon").setPositionOffset(new Vector2f(xonscreen,-1f));
        }     
        
    }

    @Override
    public void keyReleased(int key) {
       
    }
    public static void update(){
        
        if(KeyboardController.isKeyPressed(Key.KEY_RIGHT)){
            xonscreen+=0.01f;
            town.getItem("simon").setPositionOffset(new Vector2f(xonscreen,-1f));
        }
        if(KeyboardController.isKeyPressed(Key.KEY_LEFT)){
            xonscreen-=0.01f;
            town.getItem("simon").setPositionOffset(new Vector2f(xonscreen,-1f));
        }
    }

}
