package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetEndSpotCommand implements CommandExecutor {

    Speedrun main;

    public SetEndSpotCommand(Speedrun main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        Player p = null;

        if(sender instanceof Player){
            p = (Player) sender;
            if(!p.isOp()){
                p.sendMessage("lmao t'as pas la perm");
                return true;
            }
        }else{
            System.out.println("Cette commande doit être executée par un joueur ingame !");
            return true;
        }

        main.setEndLoc(p.getLocation().getBlock().getLocation());

        Block block = main.endLoc.getBlock();

        p.sendMessage("Le bloc de " + block.getType() + " situé en : " + main.getEndLoc().getX() + " / " + main.getEndLoc().getY() + " / " + main.getEndLoc().getZ() + " a été attribué comme le nouveau spot de restitution de l'oeuf.");

        return true;
    }
}
