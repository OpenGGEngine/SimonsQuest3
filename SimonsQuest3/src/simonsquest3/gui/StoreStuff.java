/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import java.util.HashMap;

/**
 *
 * @author Warren
 */
public class StoreStuff {
    public static HashMap<String, Integer> pricesstore = new HashMap<>();
    public static void init(){
        pricesstore.put("medkit", 50);
        pricesstore.put("mountaindew", 20);
    }
}
