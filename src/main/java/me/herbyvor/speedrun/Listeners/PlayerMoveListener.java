package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    Speedrun main;
    public PlayerMoveListener(Speedrun speedrun){
        this.main = speedrun;
    }


    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent e) {

        if(main.getPaused()){
            e.setCancelled(true);
        }

    }

}
