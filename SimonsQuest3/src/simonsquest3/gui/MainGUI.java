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
import simonsquest3.SimonsQuest3;
import static simonsquest3.gui.GUIMaster.font;

/**
 *
 * @author Warren
 */
public class MainGUI {
    public static GUIGroup main = new GUIGroup(new Vector2f());
    public static GUIGroup selection = new GUIGroup(new Vector2f());
    public static GUITexture select = new GUITexture(Resource.getTexture("gui/menuselect.png"),new Vector2f(-1,-1),new Vector2f(0.5f,2));
    public static GUITexture mainmenu = new GUITexture(Resource.getTexture("gui/bigmenu.png"),new Vector2f(-0.5f,-1),new Vector2f(1.5f,2));
    public static GUITexture pointer = new GUITexture(Resource.getTexture("gui/pointer.png"),new Vector2f(-1f,-1),new Vector2f(1f,1f));
    
    public static void init(){
        GUI.root.addItem("main", main);
       
        selection.addItem("Weapons",new GUIText(new Text("Weapons",new Vector2f(), 2.8f, 1f, false), font, new Vector2f(0.12f,-0.65f)));
        selection.addItem("Items",new GUIText(new Text("Items",new Vector2f(), 2.8f, 1f, false), font, new Vector2f(0.12f,-0.85f)));
        
        main.addItem("select", select);
        main.addItem("hacks", mainmenu);
        main.addItem("selecttext", selection);
        pointer.setLayer(1f);
        main.addItem("pointer", pointer);
        main.addItem("Memes", new GUIText(new Text("Attack Buff: " + SimonsQuest3.p.attackBuff + "   Defense Buff: " + SimonsQuest3.p.defenseBuff
                +"   Money: " +  SimonsQuest3.p.money +"$"
                , new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.94f, -0.1f)));
    }
    public static void update(){
        
    }
}
