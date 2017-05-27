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
public enum Effect {
    CLEAR("clear"), ATTACK("attack"), DEFENSE("defense"), HEALTH("health"), ESCAPE("escape"), DAMAGE("damage");
    
    String name;
    private Effect(String name) {
        this.name = name;
    }
}
