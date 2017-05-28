/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Ethan Mak
 */
public class Item {
    public String name;
    EffectList effects;
    public Item(String name,Effect... allEffects) {
        this.name = name;
        effects = new EffectList();
        effects.addAll(Arrays.asList(allEffects));
    }
    
    public void addEffect(Effect effect) {
        effects.add(effect);
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Item obj) {
        return obj.name.equals(this.name);
    }
}