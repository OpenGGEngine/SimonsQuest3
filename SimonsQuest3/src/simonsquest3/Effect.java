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
public class Effect {
    enumEffect stat;
    double quant;
    boolean useOnOneself;
    boolean onlyForBattle;
    
    public Effect(enumEffect stat, double quant, boolean useOnOneself) {
        this.stat = stat;
        this.quant = quant;
        this.useOnOneself = useOnOneself;
        this.onlyForBattle = false;
    }
    
    public Effect(enumEffect stat, double quant, boolean useOnOneself, boolean onlyForBattle) {
        this.stat = stat;
        this.quant = quant;
        this.useOnOneself = useOnOneself;
        this.onlyForBattle = onlyForBattle;
    }
    
    public Effect setQuant(double quant) {
        this.quant = quant;
        return this;
    }
    
    public enum enumEffect {
        CLEAR("clear"), ATTACK("attack"), DEFENSE("defense"), HEALTH("health"), ESCAPE("escape"), CHANGE_MP("mp"), ACCURACY("accuracy"), MISSED("missed");

        String name;
        private enumEffect(String name) {
            this.name = name;
        }
    }
}