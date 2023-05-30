package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Speedrun;
import me.herbyvor.speedrun.Tasks.TimeLineController;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PauseCommand implements CommandExecutor {

    Speedrun main;

    public PauseCommand(Speedrun speedrun) {
        this.main = speedrun;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p;

        if(sender instanceof Player){
            p = (Player) sender;
            if(!p.isOp()){
                p.sendMessage("lmao t'as pas la perm");
                return true;
            }
        }

        //si c la console ou si le player est op :
        if(!main.getStarted()){
            if(sender instanceof Player){
                p = (Player) sender;
                p.sendMessage("L'event n'a pas encore commencé !");
            }else{
                System.out.println("L'event n'a pas encore commencé !");
            }
            return true;
        }else {

            //pause
            if(main.getPaused()){
                //unpause
                main.setPaused(false);

                //message
                for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                    a.setInvulnerable(false);
                    a.sendTitle("§6C'est reparti !", "La pause est fini !", 10, 200, 10);
                    a.playSound(a.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 15, 1);
                }

                Bukkit.broadcastMessage("§aReprise du Speedrun !");


            }else{
                //pause
                main.setPaused(true);

                //message
                for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                    a.setInvulnerable(true);
                    a.sendTitle("§6Pause", "Un admin a mis le jeu en pause !", 10, 200, 10);
                    a.playSound(a.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 15, 1);
                }

                Bukkit.broadcastMessage("§aPause du Speedrun !");

            }

        }
        return true;
    }
}
