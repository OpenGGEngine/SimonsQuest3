/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.audio.Soundtrack;
import com.opengg.core.audio.SoundtrackHandler;
import com.opengg.core.engine.BindController;
import com.opengg.core.engine.GGApplication;
import com.opengg.core.engine.GGConsole;
import com.opengg.core.engine.OpenGG;
import com.opengg.core.engine.RenderEngine;
import com.opengg.core.engine.Resource;
import com.opengg.core.gui.GUI;
import com.opengg.core.gui.GUITexture;
import com.opengg.core.io.ControlType;
import static com.opengg.core.io.input.keyboard.Key.*;
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.shader.ShaderController;
import com.opengg.core.render.window.WindowInfo;
import com.opengg.core.render.window.WindowOptions;
import simonsquest3.gui.BattleMaster;
import simonsquest3.gui.GUIMaster;
import static simonsquest3.gui.GUIMaster.health;
import static simonsquest3.gui.GUIMaster.mana;

/**
 *
 * @author Javier
 */
public class SimonsQuest3 extends GGApplication{
    GUIMaster m;
    public static Player p;
    public static BattleController battlec;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowInfo w = new WindowInfo();
        w.displaymode = WindowOptions.WINDOWED;
        w.width = 1920;
        w.height = 1080;
        w.resizable = true;
        w.type = "GLFW";
        w.vsync = true;
        OpenGG.initialize(new SimonsQuest3(), w);
    }

    @Override
    public void setup() {
        p = new Player(100,100);
        battlec = new BattleController();
        WorldCreator.create();
        m = new GUIMaster();
        GUIMaster.init();
        GUIMaster.town.setEnabled(false);
        Soundtrack overworldday = new Soundtrack();
        overworldday.addSong(Resource.getSoundPath("windgarden.ogg"));
        overworldday.addSong(Resource.getSoundPath("floaterland.ogg"));
        overworldday.addSong(Resource.getSoundPath("intogalaxy.ogg"));
        overworldday.shuffle();
        SoundtrackHandler.setSoundtrack(overworldday);
        
        p.addAttack(AttackFactory.generateWeapon("dsword"));
        p.addAttack(AttackFactory.generateWeapon("awp"));
        p.addItem(ItemFactory.generateItem("mountaindew"));
        p.addItem(ItemFactory.generateItem("mountaindew"));
        p.addItem(ItemFactory.generateItem("mountaindew"));
        BattleMaster.init();
        BattleMaster.main.setEnabled(false);
        GGConsole.addListener(new SimonConsole());
        
        BindController.addBind(ControlType.KEYBOARD, "forward", KEY_W);
        BindController.addBind(ControlType.KEYBOARD, "backward", KEY_S);
        BindController.addBind(ControlType.KEYBOARD, "left", KEY_A);
        BindController.addBind(ControlType.KEYBOARD, "right", KEY_D);
        BindController.addBind(ControlType.KEYBOARD, "up", KEY_SPACE);
        BindController.addBind(ControlType.KEYBOARD, "down", KEY_LEFT_SHIFT);
        BindController.addBind(ControlType.KEYBOARD, "lookright", KEY_RIGHT);
        BindController.addBind(ControlType.KEYBOARD, "lookleft", KEY_LEFT);
        BindController.addBind(ControlType.KEYBOARD, "lookup", KEY_UP);
        BindController.addBind(ControlType.KEYBOARD, "lookdown", KEY_DOWN);
    }

    @Override
    public void render() {
        ShaderController.setPerspective(90, OpenGG.getWindow().getRatio(), 1f, 10000f);
    }

    @Override
    public void update(float delta) {
       battlec.update();
       BattleMaster.update();
       GUIMaster.update();
       health.actualnum = SimonsQuest3.p.health;
       mana.actualnum = SimonsQuest3.p.mana;
       if(p.health <= 0)
           GUI.root.addItem("died", new GUITexture(Resource.getTexture("died.jpg"),new Vector2f(-1,-1), new Vector2f(2,2)));
    }
    
}
