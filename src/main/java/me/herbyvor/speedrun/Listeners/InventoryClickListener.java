package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Misc.Team;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class InventoryClickListener implements Listener {

    private final static Speedrun main = Speedrun.getPlugin(Speedrun.class);
    Inventory inventory;

    public InventoryClickListener(Inventory inventory){
        this.inventory = inventory;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(Objects.equals(e.getClickedInventory(), inventory)){
            e.setCancelled(true);
            if(e.getCurrentItem() != null){
                for (Team team : main.teams){
                    if(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getDisplayName().equals(team.getName())){
                        main.getEventPlayersFromPlayer(p).setTeam(team);
                        p.sendMessage("Vous avez rejoint l'équipe " + team.getName());
                        //p.closeInventory();
                    }
                }
            }
        }
    }

}
