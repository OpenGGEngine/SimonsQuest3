/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simonsquest3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import simonsquest3.Effect.enumEffect;
import simonsquest3.gui.BattleMaster;

/**
 *
 * @author Ethan Mak
 */
public class Battle {
    Player player;
    List<Enemy> enemies;
    List<Enemy> prelimEnemies;
    Player prelimPlayer;
    int turn = 0;
    boolean chosen = false;
    
    public Battle(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
    }
    
    private void updatePlayer() {
        turn = (turn + 1) % (enemies.size() + 1);
    }
    
    public void addEnemies(Enemy... enemies) {
        this.enemies.addAll(Arrays.asList(enemies));
    }
    
    public void update() {

        if(turn % 2 == 0){
            Attack attack = AttackFactory.generateAttack("dsword");
            if(!chosen){
                return;
            }else{
                int pointer = BattleMaster.menupointer;
                if(pointer == 0){
                    attack = BattleMaster.memeList.get(BattleMaster.menupointer2);
                }else if(pointer == 1){
                    attack = BattleMaster.weaponList.get(BattleMaster.menupointer2);
                }else{
                    attack = null;
                }
                
                if(attack != null){
                    for(Effect e : attack.statusEffects) {
                        if (!e.useOnOneself)
                            for (Enemy en : enemies)
                                en.useEffect(e);
                    }
                    for (Enemy en : enemies)
                                en.useEffect(new Effect(enumEffect.HEALTH, -attack.attackPower, false));
                }
                turn++;
            }
        }else{
            //AI
        }
    }
    
    public void init() {
        prelimPlayer = player.clone();
        prelimEnemies = new ArrayList<>();
        for (Enemy e : enemies) {
            prelimEnemies.add(e.clone());
        }
    }
    
    public void close() {
        player.accuracy = prelimPlayer.accuracy;
        player.attackBuff = prelimPlayer.attackBuff;
        player.defenseBuff = prelimPlayer.defenseBuff;
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).accuracy = prelimEnemies.get(i).accuracy;
            enemies.get(i).attackBuff = prelimEnemies.get(i).attackBuff;
            enemies.get(i).defenseBuff = prelimEnemies.get(i).defenseBuff;
            enemies.get(i).health = prelimEnemies.get(i).health;
            enemies.get(i).mana = prelimEnemies.get(i).mana;
        }
    }
}
