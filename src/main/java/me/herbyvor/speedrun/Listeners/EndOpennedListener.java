package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.PortalCreateEvent;

import java.util.Objects;

public class EndOpennedListener implements Listener {

    private Speedrun main;

    public static boolean firedOnce = false;

    public EndOpennedListener(Speedrun main){
        this.main = main;
    }

    @EventHandler
    public void OnEndPortalActivation(PlayerPortalEvent e){

        if(firedOnce) return;

        //si c'est la première fois qu'un joueur entre dans l'end
        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)){

            firedOnce = true;

            System.out.println("end portal creation");

            //shrink de la bordure
            Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setSize(200, 3600);

            //activation des catastrophes
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "disasters enable randomdisasters ALL_WORLDS");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "disasters mintimer ALL_WORLDS 600");

            //display
            for(Player a : Bukkit.getOnlinePlayers()){
                a.sendTitle("§4[!]", "", 0, 20, 0);
            }
            Bukkit.broadcastMessage("§0 la bordure se referme !\nQuelque chose change...");
        }
    }

}
