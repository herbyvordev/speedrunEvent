package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalsListener implements Listener {

    Speedrun main;
    public PortalsListener(Speedrun speedrun){
        this.main = speedrun;
    }


    @EventHandler
    public void OnPortal(PlayerPortalEvent e){
        if(!main.getAllowNehter()){
            e.setCancelled(true);
            e.getPlayer().sendMessage("§4Le nether est fermé jusqu'à 30 minutes de jeu");
        }
    }

    @EventHandler
    public void OnTeleport(PlayerTeleportEvent e){
        if(!main.getAllowEnd()){
            if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)){
                e.setCancelled(true);
                e.getPlayer().sendMessage("§4L'end est fermé jusqu'à 50 minutes de jeu");
            }
        }
    }

}
