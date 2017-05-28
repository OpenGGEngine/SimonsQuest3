/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import com.opengg.core.engine.Resource;
import com.opengg.core.gui.GUI;
import com.opengg.core.gui.GUIGroup;
import com.opengg.core.gui.GUIText;
import com.opengg.core.gui.GUITexture;
import com.opengg.core.io.input.keyboard.Key;
import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.Text;
import com.opengg.core.render.texture.Texture;
import simonsquest3.Item;
import simonsquest3.SimonsQuest3;
import static simonsquest3.gui.GUIMaster.font;

/**
 *
 * @author Warren
 */
public class BattleMaster {
    public static int menupointer = 0;
    public static boolean initem = false;
    public static boolean inmain = true;
     public static GUIGroup main = new GUIGroup(new Vector2f());
    public static GUIGroup selection = new GUIGroup(new Vector2f());
    public static GUIGroup items = new GUIGroup(new Vector2f());
    public static GUITexture select = new GUITexture(Texture.get(Resource.getTexturePath("gui/menuselect.png")),new Vector2f(-1,-1),new Vector2f(0.5f,0.60f));
    public static GUITexture mainmenu = new GUITexture(Texture.get(Resource.getTexturePath("gui/bigmenu.png")),new Vector2f(-0.5f,-1),new Vector2f(1.5f,0.60f));
    public static GUITexture pointer = new GUITexture(Texture.get(Resource.getTexturePath("gui/arrow.png")),new Vector2f(-0.95f,-0.55f),new Vector2f(0.10f,0.10f));
    public static void init(){
        GUI.root.addItem("battle", main);
        selection.addItem("Memes",new GUIText(new Text("Memes",new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f,-1.45f)));
        selection.addItem("Weapons",new GUIText(new Text("Weapons",new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f,-1.55f)));
        selection.addItem("Items",new GUIText(new Text("Items",new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f,-1.65f)));
        selection.addItem("Run",new GUIText(new Text("Run",new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f,-1.75f)));
        
        main.addItem("select", select);
        main.addItem("hacks", mainmenu);
        main.addItem("selecttext", selection);
        pointer.setLayer(0.5f);
        items.enabled = false;
        main.addItem("pointer", pointer);
        main.addItem("items", items);
        regenItems();
    }
    public static void regenItems(){
        int counter = 0;
        for(Item i:SimonsQuest3.p.items.keySet()){
            items.addItem(i.name, new GUIText(new Text(i.name + ": "+ SimonsQuest3.p.items.get(i),new Vector2f(), 1f, 1f, false), font, new Vector2f(0.6f + ((counter%4
                    )*0.35f),-1.45f-(0.2f * (counter/4)))));
            counter++;
        }
    }
    public static void update(){
         if (KeyboardController.isKeyPressed(Key.KEY_UP)) {
             menupointer--;
             if(menupointer==-1){
                 menupointer = 3;
             }
             pointer.setPositionOffset(new Vector2f(-0.95f,-0.55f - (menupointer * 0.10f)));
         }
         if (KeyboardController.isKeyPressed(Key.KEY_DOWN)) {
             menupointer++;
             if(menupointer==4){
                 menupointer = 0;
             }
              pointer.setPositionOffset(new Vector2f(-0.95f,-0.55f - (menupointer * 0.10f)));
         }
         if (KeyboardController.isKeyPressed(Key.KEY_ENTER)) {
             if(inmain){
                 inmain=false;
                 pointer.enabled = false;
             switch(menupointer){
                 case 0:
                     break;
                     case 1:
                     break;
                         case 2:
                             items.enabled = true;
                     break;
                             case 3:
                                 
                     break;
             }
             }
         }
         if (KeyboardController.isKeyPressed(Key.KEY_ESCAPE)) {
             items.enabled = false;
             pointer.enabled = true;
             inmain = true;
         }
    }
}
