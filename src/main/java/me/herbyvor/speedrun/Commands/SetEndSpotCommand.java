package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;

public class SetEndSpotCommand implements CommandExecutor {

    Speedrun main;
    Plugin plugin;

    public SetEndSpotCommand(Speedrun main, Plugin plugin){
        this.main = main;
        this.plugin = plugin;
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



        main.setEndLoc(getTargetBlock(p, 5).getLocation());

        Block block = main.endLoc.getBlock();

        p.sendMessage("Le bloc de " + block.getType() + " situé en : " + main.getEndLoc().getX() + " / " + main.getEndLoc().getY() + " / " + main.getEndLoc().getZ() + " a été attribué comme le nouveau spot de restitution de l'oeuf.");

        return true;
    }

    public final Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }

}
