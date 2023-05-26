package me.herbyvor.speedrun.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CreeperDropListener implements Listener {


    @EventHandler
    public void OnCreeperDeath(EntityDeathEvent e){

        LivingEntity entity = e.getEntity();

        // getType() is inherited from Entity
        if(entity.getType() == EntityType.CREEPER) {
            e.getDrops().add(new ItemStack(Material.GUNPOWDER, 12));
        }

    }

}
