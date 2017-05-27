/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ethan Mak
 */
public abstract class GeneralEntity {
    public double health;
    public List<Weapon> attacks;
    
    protected GeneralEntity(double health, Weapon... attacks) {
        this.health = health;
        this.attacks = new ArrayList<>();
        this.attacks.addAll(Arrays.asList(attacks));
    }
}   
