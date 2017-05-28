/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.Arrays;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public boolean equals(Item obj) {
        return obj.name.equals(this.name);
    }
}