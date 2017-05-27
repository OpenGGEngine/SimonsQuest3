/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import com.opengg.core.engine.BindController;
import com.opengg.core.engine.GGApplication;
import com.opengg.core.engine.OpenGG;
import com.opengg.core.engine.RenderEngine;
import com.opengg.core.io.ControlType;
import static com.opengg.core.io.input.keyboard.Key.*;
import com.opengg.core.render.shader.ShaderController;
import com.opengg.core.render.window.WindowInfo;
import com.opengg.core.render.window.WindowOptions;
import static com.opengg.core.render.window.WindowOptions.GLFW;

/**
 *
 * @author Javier
 */
public class SimonsQuest3 extends GGApplication{

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
        
        WorldCreator.create();
        
        BindController.addBind(ControlType.KEYBOARD, "forward", KEY_W);
        BindController.addBind(ControlType.KEYBOARD, "backward", KEY_S);
        BindController.addBind(ControlType.KEYBOARD, "left", KEY_A);
        BindController.addBind(ControlType.KEYBOARD, "right", KEY_D);
        BindController.addBind(ControlType.KEYBOARD, "up", KEY_SPACE);
        BindController.addBind(ControlType.KEYBOARD, "down", KEY_LEFT_SHIFT);
        BindController.addBind(ControlType.KEYBOARD, "lookright", KEY_Q);
        BindController.addBind(ControlType.KEYBOARD, "lookleft", KEY_E);
        BindController.addBind(ControlType.KEYBOARD, "lookup", KEY_R);
        BindController.addBind(ControlType.KEYBOARD, "lookdown", KEY_F);
        BindController.addBind(ControlType.KEYBOARD, "fire", KEY_L);
        BindController.addBind(ControlType.KEYBOARD, "aim", KEY_K);
        BindController.addBind(ControlType.KEYBOARD, "freeze", KEY_O);
    }

    @Override
    public void render() {
        ShaderController.setPerspective(90, OpenGG.window.getRatio(), 0.2f, 3000f);
        RenderEngine.draw();
    }

    @Override
    public void update() {
       
    }
    
}
