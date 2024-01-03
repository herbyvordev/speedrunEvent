package me.herbyvor.speedrun.Tasks;

import me.herbyvor.speedrun.Speedrun;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EggCountdown extends BukkitRunnable {

    Speedrun main;
    private int secondes = 90;
    private final Location eggBlock;
    private final Player player;
    public EggCountdown(Speedrun main, Location shrineBlock, Player player){
        this.main = main;
        this.eggBlock = shrineBlock;
        this.player = player;
    }


    @Override
    public void run() {

        if(main.getPaused()){
            return;
        }

        if(eggBlock.getBlock().getType().equals(Material.DRAGON_EGG)){
            //on continue
            //on affiche a tous les joueurs
            for(Player p : Bukkit.getServer().getOnlinePlayers()){
                String message = "L'oeuf a été posé par " + player.getDisplayName() + " !\n" + "Il reste " + secondes + "s";
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
            }

            if(secondes == 20){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.sendTitle("§e" + secondes, "", 10, 40, 10);
                }
            }
            if(secondes == 15){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.sendTitle("§6" + secondes, "", 10, 20, 10);
                }
            }
            if(secondes <= 10 && secondes > 5){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.sendTitle("§c" + secondes, "", 0, 20, 0);
                }
            }
            if(secondes <= 5){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.sendTitle("§4" + secondes, "", 0, 20, 0);
                }
            }

        }else{

            //fail
            System.out.println(player.getDisplayName() + " a échoué a défendre l'oeuf");
            for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                a.sendTitle("§cStop !", " le timer a été interrompu !", 10, 80, 10);
                a.playSound(a.getLocation(), Sound.ENTITY_ENDERMAN_HURT, 15, 1);
            }

            cancel();
        }

        secondes --;
        if(secondes <= 0 && eggBlock.getBlock().getType().equals(Material.DRAGON_EGG)){

            //win
            System.out.println(player.getDisplayName() + " viens de rendre le dragon egg");
            for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                a.sendTitle("§6Fin", player.getDisplayName() + " a gagné le speedrun !", 10, 200, 10);
                a.playSound(a.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 15, 1);
            }
            Bukkit.broadcastMessage("§aFin du Speedrun !");
            main.setStarted(false);

            cancel();
        }
    }
}
