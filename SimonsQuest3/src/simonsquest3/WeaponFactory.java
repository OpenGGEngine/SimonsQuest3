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
public class WeaponFactory {
    public static Attack generateWeapon(String name) {
        Attack ret = new Attack(name);
        ret.mpCost = 0;
        switch (name) {
            case "airhorn":
                ret.attackPower = 10000;
                ret.durability = -1;
                ret.accuracy = 100;
                ret.name = "Airhorn";
                break;
            case "glock":
                ret.attackPower = 5;
                ret.durability = 20;
                ret.accuracy = 95;
                ret.name = "Glock";
                break;
            case "awp":
                ret.attackPower = 50;
                ret.durability = 4;
                ret.accuracy = 80;
                ret.name = "AWP";
                break;
            case "negev":
                ret.attackPower = 10;
                ret.durability = 35;
                ret.accuracy =  75;
                ret.name = "Negev";
                break;
            case "smokinggun":
                ret.attackPower = 0;
                ret.durability = 10;
                ret.accuracy = 100;
                ret.name = "Smoking Gun";
                break;
            case "vape":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.accuracy = 100;
                ret.name = "Vape";
                break;
            case "ak":
                ret.attackPower = 20;
                ret.durability = 20;
                ret.accuracy = 70;
                ret.name = "AK-47";
                break;
            case "dsword":
                ret.attackPower = 10;
                ret.durability = 50;
                ret.accuracy = 50;
                ret.name = "Diamond Sword";
                break;
            case "halogun":
                ret.attackPower = 25;
                ret.durability = 20;
                ret.accuracy = 70;
                ret.name = "Halo Gun";
                break;
            case "m4":
                ret.attackPower = 15;
                ret.durability = 30;
                ret.accuracy = 85;
                ret.name = "M4A4";
                break;
            case "smithwesson":
                ret.attackPower = 30;
                ret.durability = 10;
                ret.accuracy = 65;
                ret.name = "Smith Wesson";
                break;
            case  "default":
                ret.addEffect(new Effect(enumEffect.ESCAPE,0,true));
                break;
        }
        return ret;
    }
    
    public static Attack generateMeme(String name) {
        Attack ret = new Attack(name);
        ret.durability = -1;
        ret.accuracy = 100;
        switch (name) {
            case "wall":
                ret.attackPower = 0;
                ret.mpCost = 5;
//                ret.addEffect();
                ret.name = "Build A Wall";
                break;
            case "higherground":
                ret.attackPower = 0;
                ret.mpCost = 5;
                ret.name = "Have the Higher Groun";
                break;
        }
        return ret;
    }
    
    public static Attack generateAttack(String name) {
        Attack ret = new Attack(name);
        ret.mpCost = 0;
        ret.durability = -1;
        switch (name) {
            case "bite":
                ret.name = "Bite";
                ret.attackPower = 10;
                break;
        }
        return ret;
    }
}
