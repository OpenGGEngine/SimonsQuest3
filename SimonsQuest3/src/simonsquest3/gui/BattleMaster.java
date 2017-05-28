/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3.gui;

import com.opengg.core.engine.Resource;
import com.opengg.core.gui.GUI;
import com.opengg.core.gui.GUIGroup;
import com.opengg.core.gui.GUIText;
import com.opengg.core.gui.GUITexture;
import com.opengg.core.io.input.keyboard.Key;
import com.opengg.core.io.input.keyboard.KeyboardController;
import com.opengg.core.math.Vector2f;
import com.opengg.core.render.Text;
import com.opengg.core.render.texture.Texture;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import simonsquest3.Attack;
import simonsquest3.Item;
import simonsquest3.SimonsQuest3;
import static simonsquest3.gui.GUIMaster.font;

/**
 *
 * @author Warren
 */
public class BattleMaster {

    public static int menupointer = 0;
    public static int menupointer2 = 0;
    public static boolean initem = false;
    public static boolean inmain = true;
    public static GUIGroup main = new GUIGroup(new Vector2f());
    public static GUIGroup selection = new GUIGroup(new Vector2f());
    public static GUIGroup items = new GUIGroup(new Vector2f());
    public static GUIGroup weapons = new GUIGroup(new Vector2f());
    public static GUIGroup memes = new GUIGroup(new Vector2f());
    public static GUITexture select = new GUITexture(Texture.get(Resource.getTexturePath("gui/menuselect.png")), new Vector2f(-1, -1), new Vector2f(0.5f, 0.60f));
    public static GUITexture mainmenu = new GUITexture(Texture.get(Resource.getTexturePath("gui/bigmenu.png")), new Vector2f(-0.5f, -1), new Vector2f(1.5f, 0.60f));
    public static GUITexture pointer = new GUITexture(Texture.get(Resource.getTexturePath("gui/arrow.png")), new Vector2f(-0.95f, -0.55f), new Vector2f(0.05f, 0.05f));
    public static List<Attack> memeList = new ArrayList<>();
    public static List<Attack> weaponList = new ArrayList<>();

    public static void init() {
        GUI.root.addItem("battle", main);
        selection.addItem("Memes", new GUIText(new Text("Memes", new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f, -1.45f)));
        selection.addItem("Weapons", new GUIText(new Text("Weapons", new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f, -1.55f)));
        selection.addItem("Items", new GUIText(new Text("Items", new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f, -1.65f)));
        selection.addItem("Run", new GUIText(new Text("Run", new Vector2f(), 1.3f, 1f, false), font, new Vector2f(0.2f, -1.75f)));

        main.addItem("select", select);
        main.addItem("hacks", mainmenu);
        main.addItem("selecttext", selection);
        pointer.setLayer(0.5f);
        items.enabled = false;
        weapons.enabled = false;
        memes.enabled = false;
        main.addItem("pointer", pointer);
        main.addItem("items", items);
        main.addItem("weapons", weapons);
        main.addItem("memes", memes);
        regenItems();
        regenWeapons();
        regenMemes();
    }

    public static void regenItems() {
        int counter = 0;
        for (Item i : SimonsQuest3.p.items.keySet()) {
            items.addItem(i.name, new GUIText(new Text(i.name + ": " + SimonsQuest3.p.items.get(i), new Vector2f(), 1f, 1f, false), font, new Vector2f(0.6f + ((counter % 4) * 0.35f), -1.45f - (0.2f * (counter / 4)))));
            counter++;
        }
    }

    public static void regenWeapons() {
        int counter = 0;
        for (Attack i : SimonsQuest3.p.attacks) {
            if (!i.shitty) {

                weapons.addItem(i.name, new GUIText(new Text(i.name + ": " + i.durability + "/" + i.maxdurability, new Vector2f(), 0.9f, 1f, false), font, new Vector2f(0.55f + ((counter % 4) * 0.40f), -1.45f - (0.2f * (counter / 4)))));
                counter++;
                weaponList.add(i);
            }
        }
    }

    public static void regenMemes() {
        int counter = 0;
        for (Attack i : SimonsQuest3.p.attacks) {
            if (i.shitty) {

                memes.addItem(i.name, new GUIText(new Text(i.name + ": " + i.mpCost, new Vector2f(), 0.9f, 1f, false), font, new Vector2f(0.55f + ((counter % 4) * 0.40f), -1.45f - (0.2f * (counter / 4)))));
                counter++;
                memeList.add(i);
            }
        }
    }

    public static void update() {
        if(!main.enabled)
            return;
        if (KeyboardController.isKeyPressed(Key.KEY_UP)) {
            menupointer--;
            if (menupointer == -1) {
                menupointer = 3;
            }
            pointer.setPositionOffset(new Vector2f(-0.95f, -0.55f - (menupointer * 0.10f)));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BattleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (KeyboardController.isKeyPressed(Key.KEY_DOWN)) {
            menupointer++;
            if (menupointer == 4) {
                menupointer = 0;
            }
            pointer.setPositionOffset(new Vector2f(-0.95f, -0.55f - (menupointer * 0.10f)));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BattleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (KeyboardController.isKeyPressed(Key.KEY_LEFT)) {
            if (memes.enabled | weapons.enabled) {
                menupointer2--;
                 pointer.setPositionOffset(new Vector2f(-0.53f + ((menupointer2 % 4) * 0.35f), -0.5f - (0.2f * (menupointer2 / 4))));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BattleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (KeyboardController.isKeyPressed(Key.KEY_RIGHT)) {
            if (memes.enabled | weapons.enabled) {
                menupointer2++;
                 pointer.setPositionOffset(new Vector2f(-0.53f + ((menupointer2 % 4) * 0.35f), -0.5f - (0.2f * (menupointer2 / 4))));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BattleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (KeyboardController.isKeyPressed(Key.KEY_ENTER)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(BattleMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (memes.enabled | weapons.enabled) {
                SimonsQuest3
                        .battlec
                        .curbattle
                        .chosen = true;
                items.enabled = false;
                weapons.enabled = false;
                memes.enabled = false;
                inmain = true;
                menupointer2 = 0;
            }
            if (inmain) {
                inmain = false;
                pointer.setPositionOffset(new Vector2f(-0.53f + ((menupointer2 % 4) * 0.35f), -0.5f - (0.2f * (menupointer2 / 4))));
                switch (menupointer) {
                    case 0:
                        memes.enabled = true;
                        break;
                    case 1:
                        weapons.enabled = true;
                        break;
                    case 2:
                        items.enabled = true;
                        break;
                    case 3:
                        SimonsQuest3.battlec.curbattle.chosen = true;
                        break;
                }
            }
            
        }
        if (KeyboardController.isKeyPressed(Key.KEY_ESCAPE)) {
            items.enabled = false;
            weapons.enabled = false;
            memes.enabled = false;
            inmain = true;
            menupointer2 = 0;
            pointer.setPositionOffset(new Vector2f(-0.95f, -0.55f - (menupointer * 0.10f)));
        }
    }
}
