/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import com.opengg.core.engine.Resource;
import com.opengg.core.engine.WorldEngine;
import com.opengg.core.gui.GUI;
import com.opengg.core.gui.GUIGroup;
import com.opengg.core.gui.GUIItem;
import com.opengg.core.gui.GUIText;
import com.opengg.core.gui.GUITexture;
import com.opengg.core.io.input.keyboard.Key;
import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.io.input.keyboard.KeyboardListener;
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.Text;
import com.opengg.core.render.texture.text.GGFont;
import java.util.logging.Level;
import java.util.logging.Logger;
import simonsquest3.ItemFactory;
import simonsquest3.SimonsQuest3;

/**
 *
 * @author Warren
 */
public class GUIMaster implements KeyboardListener {

    static float xonscreen = 0;
    static int storepointer = 0;
    public static GUIGroup town = new GUIGroup(new Vector2f());
    public static GUIItem simon = new GUITexture(Resource.getTexture("/gui/simon.png"), new Vector2f(-0.6f, -1f), new Vector2f(0.25f, 0.75f));
    public static GUIItem simonstatue = new GUITexture(Resource.getTexture("/gui/blackmarket.png"), new Vector2f(0, -0.4f), new Vector2f(0.55f, 0.75f));
    public static GUIItem hotel = new GUITexture(Resource.getTexture("/gui/hotelmario.png"), new Vector2f(2f, -0.4f), new Vector2f(0.55f, 0.75f));
    public static GUIItem storeland = new GUITexture(Resource.getTexture("/gui/storeland.png"), new Vector2f(0.8f, -0.4f), new Vector2f(1f, 0.75f));
    public static GUIGroup store = new GUIGroup(new Vector2f());
    public static GUIGroup menustore = new GUIGroup(new Vector2f());
    public static GUIGroup hotels = new GUIGroup(new Vector2f());
    public static GUIGroup hud = new GUIGroup(new Vector2f());

    public static GUIItem vendor = new GUITexture(Resource.getTexture("/gui/boss.png"), new Vector2f(0.1f, -0.75f), new Vector2f(0.85f, 1.6f));
    public static GUIItem vendor2 = new GUITexture(Resource.getTexture("/gui/jedi.png"), new Vector2f(0.1f, -1f), new Vector2f(0.75f, 1.5f));
    public static GUIItem vendorback = new GUITexture(Resource.getTexture("/gui/storecounter.jpg"), new Vector2f(-1f, -1f), new Vector2f(2f, 2f));
    public static GUIItem townback = new GUITexture(Resource.getTexture("/gui/townbackground.png"), new Vector2f(-1, -1), new Vector2f(2, 2));
    public static GUIItem counter = new GUITexture(Resource.getTexture("/gui/counter.png"), new Vector2f(0f, -1), new Vector2f(1, 1));
    public static GUIItem pointer = new GUITexture(Resource.getTexture("/gui/pointer.png"), new Vector2f(-1f, 0.65f), new Vector2f(0.15f, 0.15f));
    public static GUIItem menupic = new GUITexture(Resource.getTexture("/gui/menupicture.png"), new Vector2f(-1f, 0.6f), new Vector2f(0.35f, 0.35f));

    public static GGFont font = new GGFont("C:/res/test.png", "C:/res/test.fnt");
    public static GUIText text = new GUIText(new Text("Black Market", new Vector2f(), 4f, 1f, false), font, new Vector2f(0.9f, 0));
    public static GUIText text1 = new GUIText(new Text("Money:" + 100, new Vector2f(), 0.25f, 1f, false), font, new Vector2f(0, -0.05f));
    public static GUIText text2 = new GUIText(new Text( SimonsQuest3.p.health+"/"+ SimonsQuest3.p.maxHealth +"  Money: " + SimonsQuest3.p.money, new Vector2f(), 1.5f, 1.1f, false), font,
            new Vector2f(0.85f, -0.11f));

    public static GUIBar mana = new GUIBar(Resource.getTexture("/gui/EmptyBar.png"), Resource.getTexture("/gui/BlueBar.png"), new Vector2f(-0.7f, 0.6f), new Vector2f(0.5f, 0.1f),100);
    public static GUIBar health = new GUIBar(Resource.getTexture("/gui/EmptyBar.png"), Resource.getTexture("/gui/RedBar.png"), new Vector2f(-0.7f, 0.8f), new Vector2f(0.5f, 0.1f),100);
    public static boolean instore = false;

    public static void init() {
        StoreStuff.init();
        GUI.root.addItem("town", town);
        GUI.root.addItem("store", store);
        GUI.root.addItem("hud", hud);
        town.enabled = false;

        town.addItem("townbackground", townback);
        town.addItem("simons", simonstatue);
        town.addItem("simon", simon);
        town.addItem("hotel", hotel);
        hotel.setLayer(-1.1f);
        store.setLayer(1.5f);
        store.addItem("vendor", vendor);
        town.getItem("townbackground").setLayer(-1.1f);
        town.getItem("simons").setLayer(-1.1f);

        town.addItem("store", storeland);
        storeland.setLayer(-1.1f);
        store.addItem("title", text);
        store.addItem("counter", counter);
        store.addItem("pointer", pointer);
        store.enabled = false;
        float offset = -0.2f;
        for (String i : StoreStuff.pricesstore.keySet()) {
            menustore.addItem(i, new GUIText(new Text(i.substring(0, 1).toUpperCase() + i.substring(1) + ": " + StoreStuff.pricesstore.get(i), new Vector2f(), 2f, 1f, false), font, new Vector2f(0.2f, offset)));
            offset -= 0.1f;
        }
        offset = -0.2f;
        for (String i : StoreStuff.hotel.keySet()) {
            hotels.addItem(i, new GUIText(new Text(i.substring(0, 1).toUpperCase() + i.substring(1) + ": " + StoreStuff.pricesstore.get(i), new Vector2f(), 2f, 1f, false), font, new Vector2f(0.2f, offset)));
            offset -= 0.1f;
        }
        store.addItem("magic", menustore);
        store.addItem("money", text1);
        hud.addItem("mana", mana);
        hud.addItem("health", health);
        hud.addItem("tag", text2);

        hud.addItem("simon", menupic);
        menupic.setLayer(0.75f);
        health.setLayer(0.75f);
        mana.setLayer(0.75f);

    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    public static int checkPosition() {
        if (xonscreen < -0.5 && xonscreen > -1.05) {
            text.setText("Black Market");
            store.addItem("vendor", vendor);
            store.addItem("magic", menustore);
            return 1;
        }
        if (xonscreen < -1.31 && xonscreen > -2.3) {
            text.setText("Traveling Salesman");
            store.addItem("vendor", vendor2);
            store.addItem("magic", menustore);
            return 2;
        }
        if (xonscreen < -2.55 && xonscreen > -3) {
            text.setText("Hotel Mario");
            store.addItem("vendor", vendor2);
            store.addItem("magic", hotels);
            return 3;
        }
        return -1;
    }

    public static void update() {
        if (!town.enabled) {
            hud.enabled = true;
            return;
        }
        hud.enabled = false;
        if (KeyboardController.isKeyPressed(Key.KEY_RIGHT)) {
            xonscreen -= 0.04f;
            town.getItem("simons").setPositionOffset(new Vector2f(xonscreen, -0.4f));
            town.getItem("store").setPositionOffset(new Vector2f(0.8f + xonscreen, -0.4f));
            hotel.setPositionOffset(new Vector2f(2f + xonscreen, -0.4f));
        }
        if (KeyboardController.isKeyPressed(Key.KEY_LEFT)) {
            xonscreen += 0.04f;
            town.getItem("simons").setPositionOffset(new Vector2f(xonscreen, -0.4f));
            town.getItem("store").setPositionOffset(new Vector2f(0.8f + xonscreen, -0.4f));
            hotel.setPositionOffset(new Vector2f(2f + xonscreen, -0.4f));
        }
        if (KeyboardController.isKeyPressed(Key.KEY_UP)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUIMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            storepointer--;
            if (storepointer < 0) {
                storepointer = 0;
            }
            store.getItem("pointer").setPositionOffset(new Vector2f(-1, 0.65f - (storepointer * 0.1f)));

        }
        if (KeyboardController.isKeyPressed(Key.KEY_DOWN)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUIMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            storepointer++;

            store.getItem("pointer").setPositionOffset(new Vector2f(-1, 0.65f - (storepointer * 0.1f)));

        }
        if (KeyboardController.isKeyPressed(Key.KEY_ENTER)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUIMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            int townie = checkPosition();
            if (townie != -1) {

                if (!instore) {
                    simon.enabled = false;
                    town.addItem("townbackground", vendorback);
                    store.enabled = true;
                    instore = true;
                } else {
                    if (townie == 3) {
                        if (20 <= SimonsQuest3.p.money) {
                            SimonsQuest3.p.money -= 20;
                            SimonsQuest3.p.health =  SimonsQuest3.p.maxHealth;
                            SimonsQuest3.p.mana =  SimonsQuest3.p.maxMana;
                        }
                    } else {
                        int i = StoreStuff.pricesstore.get(StoreStuff.faker.get(storepointer));
                        System.out.println(SimonsQuest3.p.money);
                        if (i <= SimonsQuest3.p.money) {
                            SimonsQuest3.p.money -= i;

                            SimonsQuest3.p.addItem(ItemFactory.generateItem(StoreStuff.faker.get(storepointer)));
                            text1.setText("Money: " + SimonsQuest3.p.money + "$");

                        }
                    }
                }
            }
        }
        if (KeyboardController.isKeyPressed(Key.KEY_ESCAPE)) {
            if (instore) {
                simon.enabled = true;
                town.addItem("townbackground", townback);
                store.enabled = false;
                instore = false;
            }else{
                town.enabled = false;
                WorldEngine.getCurrent().setEnabled(true);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
             
            }
        }
        
    }

}
