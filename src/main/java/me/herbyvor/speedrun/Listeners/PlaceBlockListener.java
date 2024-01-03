package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import me.herbyvor.speedrun.Tasks.EggCountdown;
import me.herbyvor.speedrun.Tasks.TimeLineController;
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
            System.out.println("placed draggon egg");
            if(e.getBlockAgainst().getLocation().equals(main.getEndLoc())){
                System.out.println("placed against endloc");
                if(main.getStarted()){
                    System.out.println("started = true");
                    //start timer
                    System.out.println(e.getPlayer().getDisplayName() + " a posé l'oeuf");
                    for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                        a.sendTitle("§cTimer !", e.getPlayer().getDisplayName() + " a posé l'oeuf !", 10, 80, 10);
                        a.playSound(a.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 15, 1);
                    }
                    Bukkit.broadcastMessage(e.getPlayer().getDisplayName() + " doit défendre l'oeuf pendant 1 minute 30 !");

                    new EggCountdown(main, e.getBlock().getLocation(), e.getPlayer()).runTaskTimer(main, 0, 20);

                }
            }
        }
    }

}
