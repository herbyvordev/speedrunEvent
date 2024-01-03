package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Misc.Lootchests;
import me.herbyvor.speedrun.Speedrun;
import me.herbyvor.speedrun.Tasks.TimeLineController;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    Speedrun main;

    public StartCommand(Speedrun speedrun) {
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
        if(main.getStarted()){
            if(sender instanceof Player){
                p = (Player) sender;
                p.sendMessage("L'event a déjà commencé !");
            }else{
                System.out.println("L'event a déjà commencé !");
            }
            return true;
        }else {

            //start
            main.setStarted(true);
            new TimeLineController(main, new Lootchests(main)).runTaskTimer(main, 0, 20);

            //message
            for (Player a : Bukkit.getServer().getOnlinePlayers()) {
                a.setGameMode(GameMode.SURVIVAL);
                a.setInvulnerable(false);
                a.setFoodLevel(20);
                a.setHealth(20);
                a.sendTitle("§6C'est parti !", "Que les meilleurs gagnent !", 10, 200, 10);
                a.playSound(a.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 15, 1);
            }

            Bukkit.broadcastMessage("§aDébut du Speedrun !");

        }

        return true;
    }
}
