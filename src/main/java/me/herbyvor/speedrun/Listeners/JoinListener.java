package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class JoinListener implements Listener {

    Speedrun main;
    public JoinListener(Speedrun speedrun){
        this.main = speedrun;
    }


    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(!main.getStarted()){
            p.teleport(main.spawn);
            p.setGameMode(GameMode.ADVENTURE);
            p.setInvulnerable(true);
            p.setFoodLevel(20);
            p.setHealth(20);
        }else {
            if(p.getGameMode() != GameMode.SURVIVAL){
                p.setGameMode(GameMode.SURVIVAL);
            }
        }
    }

}
