package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
public class PlaceBlockListener implements Listener {

    Speedrun main;
    public PlaceBlockListener(Speedrun speedrun){
        this.main = speedrun;
    }

    @EventHandler
    public void OnPlaceBlock(BlockPlaceEvent e){
        if(e.getBlockPlaced().getType().equals(Material.DRAGON_EGG)){
            Location endgame = new Location(Bukkit.getWorld("world"), 0, 65, 0);
            if(e.getBlockAgainst().getLocation().equals(endgame)){
                if(main.getStarted()){
                    System.out.println(e.getPlayer().getDisplayName() + " viens de rendre le dragon egg");
                    for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                        a.sendTitle("§6Fin", e.getPlayer().getDisplayName() + "viens de rendre le dragon egg !", 10, 200, 10);
                        a.playSound(a.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 15, 1);
                    }
                    Bukkit.broadcastMessage("§aFin du Speedrun !");
                    main.setStarted(false);
                }
            }
        }
    }

}
