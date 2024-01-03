package me.herbyvor.speedrun.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class AchievmentsListener implements Listener {


    @EventHandler
    public void OnPlayerAchieveEvent(PlayerAdvancementDoneEvent event){

        if(event.getAdvancement().getKey().toString().contains("minecraft:recipes")) {
            return;
        } else {
            Player p = event.getPlayer();

            int score = 0;

            System.out.println(p.getName() + " has done the advancement : " + Objects.requireNonNull(event.getAdvancement().getDisplay()).getTitle());

            switch (Objects.requireNonNull(event.getAdvancement().getDisplay()).getTitle().toLowerCase()) {
                case "bee our guest":
                case "bullseye":
                case "fishy business":
                case "local brewery":
                    score = 1;
                    break;
                case "light as a rabbit":
                case "sniper duel":
                case "return to sender":
                case "what a deal":
                    score = 2;
                    break;
                case "sticky situation":
                case "respecting the remnants":
                case "it spreads":
                case "hero of the village":
                    score = 3;
                    break;
                case "withering heights":
                    score = 15;
                    break;
            }

            p.getInventory().addItem( new ItemStack(Material.ENDER_PEARL, score));
            p.sendMessage("Vous avez recut " + score + " ender pearls !");

        }

    }

}
