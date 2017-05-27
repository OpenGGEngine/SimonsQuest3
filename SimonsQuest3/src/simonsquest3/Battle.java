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
        switch (turn) {
            case 0:
                used = player.waitForChoice();
                break;
            default:
                used = enemies.get(turn-1).attack(player.health);
                break;
        }
        if (used == null)
            return used;
        Map<Effect, Double> effects = used.use(turn == 0? 0 : 1, (turn == 0));
        if (turn > 0) {
            for (Map.Entry<Effect,Double> attack: effects.entrySet())
                enemies.get(turn-1).useEffect(attack.getKey(),attack.getValue());
            player.damage(effects.get(Effect.DAMAGE));
        }
        updatePlayer();
        return used;
    }
}
