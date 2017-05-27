/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Warren
 */
public class Town {
    public ArrayList<TownItem> buildings = new ArrayList<>();
    
    public Town(TownItem ... a){
        for(TownItem b:a){
            buildings.add(b);
        };
    }
    public void initGUI(){
        
    }
}
