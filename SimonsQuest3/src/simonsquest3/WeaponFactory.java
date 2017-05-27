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
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Glock";
                break;
            case "awp":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "AWP";
                break;
            case "negev":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Negev";
                break;
            case "smokinggun":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.mpCost = 0;
                ret.name = "Smoking Gun";
                break;
            case "vape":
                ret.attackPower = 0;
                ret.durability = 0;
                ret.name = "Vape";
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
