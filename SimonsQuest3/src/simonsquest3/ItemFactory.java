/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

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
               ret.addEffect(Effect.ESCAPE, 0);
               break;
           case "mountaindew":
               ret.name = "Mountain Dew";
               ret.addEffect(Effect.ATTACK,1);
               ret.addEffect(Effect.HEALTH, 1);
               break;
           case "honey":
               ret.name = "Ray liotta's Honey";
               ret.addEffect(Effect.DEFENSE, 1);
               ret.addEffect(Effect.HEALTH, 1);
               break;
           case "medkit":
               ret.name = "Medkit";
               ret.addEffect(Effect.HEALTH, 1);
               break;
           case "deathsticks":
               ret.name = "Death Sticks";
               ret.addEffect(Effect.HEALTH, 2);
               ret.addEffect(Effect.DEFENSE, -1);
               break;
       }
       return ret;
    }
}
