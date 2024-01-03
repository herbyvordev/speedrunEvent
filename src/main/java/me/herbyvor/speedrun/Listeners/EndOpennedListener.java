package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

import java.util.Objects;

public class EndOpennedListener implements Listener {

    private Speedrun main;

    public EndOpennedListener(Speedrun main){
        this.main = main;
    }

    @EventHandler
    public void OnEndPortalActivation(PortalCreateEvent e){
        for(BlockState b : e.getBlocks()){
            if(b.getBlock().getType().equals(Material.END_PORTAL_FRAME)){
                System.out.println("end portal creation");
                Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setSize(200, 3600);
                //add la commande de start du plugin de catastrophes naturelles ici
            }
        }
    }

}
