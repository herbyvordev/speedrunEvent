package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
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

        Player p = e.getPlayer();
        Location bedloc = p.getBedSpawnLocation();

        if(e.getFrom().getName().equals("world_the_end")){

            //si il a un lit et que c'est safe de l'y tp, on le tp a son lit et on fait rien d'autre
            if(bedloc != null){
                if(!Objects.requireNonNull(Bukkit.getServer().getWorld("world")).getWorldBorder().isInside(bedloc)){
                    return;
                }
            }

            rtpToOverworld(p);
            p.sendMessage("votre lit ou point de respawn était innaccessible");

        }
        if(e.getFrom().getName().equals("world_nether")){
            if(!Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().isInside(e.getPlayer().getLocation())){
                rtpToOverworld(p);
                p.sendMessage("votre portail était situé dans la world border");
            }
        }

    }

    public void rtpToOverworld(Player p){

        int max = (int) Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().getSize();

        Random r = new Random();
        double x;
        double z;

        boolean posx = Math.random() < 0.5;
        boolean posz = Math.random() < 0.5;
        if(posx){
            x = r.nextInt(max);
        }else{
            x = -r.nextInt(max);
        }
        if(posz){
            z = r.nextInt(max);
        }else{
            z = -r.nextInt(max);
        }

        double y = Objects.requireNonNull(Bukkit.getWorld("world")).getHighestBlockYAt((int)x, (int)z);

        Location rtploc = new Location(Bukkit.getWorld("world"), x, y, z);

        p.teleport(rtploc);

        p.sendMessage("vous avez été téléporté alleatoirement");

    }

}
