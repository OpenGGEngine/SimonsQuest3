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
import com.opengg.core.io.ControlType;
import static com.opengg.core.io.input.keyboard.Key.*;
import com.opengg.core.render.shader.ShaderController;
import com.opengg.core.render.window.WindowInfo;
import com.opengg.core.render.window.WindowOptions;
import static com.opengg.core.render.window.WindowOptions.GLFW;
import simonsquest3.gui.BattleMaster;
import simonsquest3.gui.GUIMaster;

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
        w.type = GLFW;
        w.vsync = true;
        OpenGG.initialize(new SimonsQuest3(), w);
    }

    @Override
    public void setup() {
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
        p = new Player(100,100);
        p.addAttack(AttackFactory.generateWeapon("dsword"));
        p.addAttack(AttackFactory.generateWeapon("awp"));
        p.addAttack(AttackFactory.generateMeme("wall"));
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
        ShaderController.setPerspective(90, OpenGG.window.getRatio(), 1f, 10000f);
        RenderEngine.draw();
    }

    @Override
    public void update() {
       battlec.update();
       BattleMaster.update();
       GUIMaster.update();
    }
    
}
