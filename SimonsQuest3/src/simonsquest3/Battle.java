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

/**
 *
 * @author Ethan Mak
 */
public class Battle {
    Player player;
    List<Enemy> enemies;
    int turn = 0;
    
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
    
    public Weapon battleTurn() {
        Weapon used;
        int target;
        switch (turn) {
            case 0:
                Map.Entry<Weapon, Integer> temp = player.waitForChoice();
                used = temp.getKey();
                target = temp.getValue();
                break;
            default:
                used = enemies.get(turn-1).attack(player.health);
                target = 0;
                break;
        }
        if (used == null)
            return used;
        List<Effect> effects = used.use(turn == 0? 0 : 1, (turn == 0));
        if (turn > 0) {
            for (Effect e : effects)
                if (!e.useOnOneself)
                    player.useEffect(e);
        } else {
            for (Effect e : effects)
                if (!e.useOnOneself)
                    enemies.get(target - 1).useEffect(e);
        }
        updatePlayer();
        return used;
    }
    
    public void run() {
        
    }
    
    public void close() {
        
    }
}
