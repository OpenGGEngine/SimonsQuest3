/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import com.opengg.core.gui.GUIRenderable;
import com.opengg.core.math.Matrix4f;
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.objects.ObjectCreator;
import com.opengg.core.render.shader.ShaderController;
import static com.opengg.core.render.shader.ShaderController.setUniform;
import com.opengg.core.render.texture.Texture;

/**
 *
 * @author Warren
 */
public class GUIBar extends GUIRenderable{
    public Texture empty;
    public Texture full;
    public double fullnum = 100;
    public double actualnum = 60;
    public GUIBar(Texture empty,Texture full,Vector2f position,Vector2f size){
        super(ObjectCreator.createSquare(new Vector2f(), size,0 ),position);
        this.empty= empty;
        this.full = full;
        
    }
    @Override
    public void render(){
        ShaderController.useConfiguration("bar");
        setUniform("percent", (float)(actualnum/fullnum));
        empty.useTexture(0);
        full.useTexture(1);
        super.render();
        ShaderController.useConfiguration("gui");
    }
}
