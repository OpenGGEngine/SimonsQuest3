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
public class AttackFactory {
    public static Attack generateWeapon(String name) {
        Attack ret = new Attack(name,false);
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
        Attack ret = new Attack(name,true);
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
            case  "production":
                ret.name = "Sieze the Means of Production";
                break;
            case "sand":
                ret.name = "Coarse Rough Sand";
                break;
        }
        return ret;
    }
    
    public static Attack generateAttack(String name) {
        Attack ret = new Attack(name,false);
        ret.mpCost = 0;
        ret.durability = -1;
        switch (name) {
            case "bite":
                ret.name = "Bite";
                ret.attackPower = 15;
                ret.accuracy = 70;
                break;
            case "rear":
                ret.name = "Rear Teeth";
                ret.attackPower = 0;
                ret.accuracy = 100;
                ret.addEffect(new Effect(enumEffect.ATTACK,5,true));
                ret.addEffect(new Effect(enumEffect.DEFENSE, -5, false));
                break;
            case "dam":
                ret.name = "Build Dam";
                ret.attackPower = 0;
                ret.accuracy = 85;
                ret.addEffect(new Effect(enumEffect.DEFENSE,15, true));
                break;
            case "sing":
                ret.name = "Sing";
                ret.attackPower = 10;
                ret.accuracy = 82;
                break;
            case "fans":
                ret.name = "Use Fans";
                ret.attackPower = 5;
                ret.accuracy = 75;
                ret.addEffect(new Effect(enumEffect.ATTACK,10, true));
                break;
            case "csite":
                ret.name = "Push C Site";
                ret.attackPower = 10;
                ret.accuracy = 100;
                break;
            case "spinbot":
                ret.name = "Use Spinbot";
                ret.attackPower = 15;
                ret.accuracy = 90;
                ret.addEffect(new Effect(enumEffect.DEFENSE,-5, true));
                break;
            case "p90":
                ret.name = "P90 Rush";
                ret.attackPower = 40;
                ret.accuracy = 30;
                break;
            case "shield":
                ret.name = "Use Energy Shield";
                ret.attackPower = 0;
                ret.accuracy = 100;
                ret.addEffect(new Effect(enumEffect.DEFENSE,15, true));
                break;
            case "banshee":
                ret.name = "Ride Banshee";
                ret.attackPower = 30;
                ret.accuracy = 50;
                break;
            case "cortana":
                ret.name = "Consult with Cortana";
                ret.attackPower = 0;
                ret.accuracy = 100;
                ret.addEffect(new Effect(enumEffect.ATTACK,10, true));
                break;
            case "sue":
                ret.name = "Sue Companies";
                ret.attackPower = 20;
                ret.accuracy = 80;
                break;
            case "jazz":
                ret.name = "Like Jazz";
                ret.attackPower = 10;
                ret.accuracy = 0;
                ret.addEffect(new Effect(enumEffect.DEFENSE,7, true));
                ret.addEffect(new Effect(enumEffect.ATTACK,7, true));
                break;
            case "sting":
                ret.name = "Sting";
                ret.attackPower = 30;
                ret.accuracy = 50;
                break;
            case "miss":
                ret.name = "Miss Shot";
                ret.attackPower = 80;
                ret.accuracy = 3;
                break;
            case "headbutt":
                ret.name = "Headbutt";
                ret.attackPower = 25;
                ret.accuracy = 85;
                break;
            case "order66":
                ret.name = "Execute Order 66";
                ret.attackPower = 60;
                ret.accuracy = 60;
                ret.addEffect(new Effect(enumEffect.HEALTH,-10,true));
                break;
                
        }
        return ret;
    }
}
