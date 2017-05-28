/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Warren
 */
public class StoreStuff {
    public static HashMap<String, Integer> pricesstore = new HashMap<>();
    public static HashMap<String, Integer> blackmarket = new HashMap<>();
    public static HashMap<String, Integer> hotel = new HashMap<>();
    public static ArrayList<String> faker = new ArrayList<>();
    public static void init(){
        pricesstore.put("medkit", 50);
        faker.add("medkit");
        pricesstore.put("mountaindew", 20);
        faker.add("mountaindew");
        pricesstore.put("honey", 80);
        faker.add("honey");
        hotel.put("Yes I Want to Stay", 20);
    }
}
