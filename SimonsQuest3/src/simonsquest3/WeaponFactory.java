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
public class WeaponFactory {
    public static Weapon generateWeapon(String name) {
        Weapon ret = new Weapon(name);
        ret.mpCost = 0;
        switch (name) {
            case "airhorn":
                ret.attackPower = 10000;
                ret.durability = -1;
                ret.name = "Airhorn";
                break;
            case "glock":
                ret.attackPower = 5;
                ret.durability = 20;
                ret.name = "Glock";
                break;
            case "awp":
                ret.attackPower = 50;
                ret.durability = 4;
                ret.name = "AWP";
                break;
            case "negev":
                ret.attackPower = 10;
                ret.durability = 35;
                ret.name = "Negev";
                break;
            case "smokinggun":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Smoking Gun";
                break;
            case "vape":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Vape";
                break;
            case "ak":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "AK-47";
                break;
            case "dsword":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Diamond Sword";
                break;
            case "halogun":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Halo Gun";
                break;
            case "m4":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "M4A4";
                break;
            case "smithwesson":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Smith Wesson";
                break;
        }
        return ret;
    }
    
    public static Weapon generateMeme(String name) {
        Weapon ret = new Weapon(name);
        ret.durability = -1;
        switch (name) {
            
        }
        return ret;
    }
    
    public static Weapon generateAttack(String name) {
        Weapon ret = new Weapon(name);
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
