package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Objects;
import java.util.Random;

public class PortalsListener implements Listener {

    Speedrun main;
    public PortalsListener(Speedrun speedrun){
        this.main = speedrun;
    }


    @EventHandler
    public void OnPortal(PlayerPortalEvent e){
        if(!main.getAllowEnd()){
            if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)){
                e.setCancelled(true);
                e.getPlayer().sendMessage("§4L'end est fermé jusqu'à 1 heure de jeu");
            }
        }
        if(!main.getAllowNehter()){
            if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage("§4Le nether est fermé jusqu'à 30 minutes de jeu");
            }
        }
    }

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e){

        if(e.getFrom().getName().equals("world_the_end")){

            Random r = new Random();
            double x;
            double z;

            boolean posx = Math.random() < 0.5;
            boolean posz = Math.random() < 0.5;
            if(posx){
                x = r.nextInt(1000)+500; //entre 500 et 1500
            }else{
                x = r.nextInt(1000)-1500; //entre -500 et -1500
            }
            if(posz){
                z = r.nextInt(1000)+500; //entre 500 et 1500
            }else{
                z = r.nextInt(1000)-1500; //entre -500 et -1500
            }

            double y = Objects.requireNonNull(Bukkit.getWorld("world")).getHighestBlockYAt((int)x, (int)z);

            Location rtploc = new Location(Bukkit.getWorld("world"), x, y, z);

            e.getPlayer().teleport(rtploc);

        }

    }

}
