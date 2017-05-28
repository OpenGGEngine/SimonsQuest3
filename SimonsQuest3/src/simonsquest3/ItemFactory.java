/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import simonsquest3.Effect.enumEffect;

/**
 *
 * @author Ethan Mak
 */
public class ItemFactory {
    public static Item generateItem(String name) {
       Item ret = new Item(name);
       switch (name) {
           case "flashbang":
               ret.name = "Flashbang";
               ret.addEffect(new Effect(enumEffect.ESCAPE, 0, true));
               break;
           case "mountaindew":
               ret.name = "Mountain Dew";
               ret.addEffect(new Effect(enumEffect.ATTACK, 1, true));
               ret.addEffect(new Effect(enumEffect.HEALTH, 1, true));
               break;
           case "honey":
               ret.name = "Ray liotta's Honey";
               ret.addEffect(new Effect(enumEffect.DEFENSE, 1, true));
               ret.addEffect(new Effect(enumEffect.HEALTH, 1, true));
               break;
           case "medkit":
               ret.name = "Medkit";
               ret.addEffect(new Effect(enumEffect.HEALTH, 1, true));
               break;
           case "deathsticks":
               ret.name = "Death Sticks";
               ret.addEffect(new Effect(enumEffect.ESCAPE, 2, true));
               ret.addEffect(new Effect(enumEffect.DEFENSE, -1, true));
               break;
       }
       return ret;
    }
}
