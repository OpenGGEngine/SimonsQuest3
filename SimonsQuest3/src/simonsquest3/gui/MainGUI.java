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
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.Text;
import com.opengg.core.render.texture.Texture;
import static simonsquest3.gui.GUIMaster.font;

/**
 *
 * @author Warren
 */
public class MainGUI {
    public static GUIGroup main = new GUIGroup(new Vector2f());
    public static GUIGroup selection = new GUIGroup(new Vector2f());
    public static GUITexture select = new GUITexture(Texture.get(Resource.getTexturePath("gui/menuselect.png")),new Vector2f(-1,-1),new Vector2f(0.5f,2));
    public static GUITexture mainmenu = new GUITexture(Texture.get(Resource.getTexturePath("gui/bigmenu.png")),new Vector2f(-0.5f,-1),new Vector2f(1.5f,2));
    public static GUITexture pointer = new GUITexture(Texture.get(Resource.getTexturePath("gui/pointer.png")),new Vector2f(-1f,-1),new Vector2f(1f,1f));
    public static void init(){
        GUI.root.addItem("main", main);
        selection.addItem("Status",new GUIText(new Text("Status",new Vector2f(), 2.8f, 1f, false), font, new Vector2f(0.12f,-0.05f)));
        selection.addItem("Weapons",new GUIText(new Text("Weapons",new Vector2f(), 2.8f, 1f, false), font, new Vector2f(0.12f,-0.25f)));
        selection.addItem("Items",new GUIText(new Text("Items",new Vector2f(), 2.8f, 1f, false), font, new Vector2f(0.12f,-0.45f)));
        
        main.addItem("select", select);
        main.addItem("hacks", mainmenu);
        main.addItem("selecttext", selection);
        pointer.setLayer(1f);
        main.addItem("pointer", pointer);
    }
    public static void update(){
        
    }
}
