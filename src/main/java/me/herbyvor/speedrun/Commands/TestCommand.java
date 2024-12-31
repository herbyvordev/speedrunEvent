package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Misc.Utils;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestCommand extends Utils implements CommandExecutor {

    private Speedrun main;

    public TestCommand(Speedrun main){ this.main = main; }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player p = (Player) commandSender;

        if(!p.isOp()){
            p.sendMessage("t'a pas la perm connard");
            return true;
        }

        //for test purposes
        //p.getInventory().addItem(createGuiItem(Material.DRAGON_EGG, "", ""));

        

        p.sendMessage("Le bloc situé en : " + main.getEndLoc().getX() + " / " + main.getEndLoc().getY() + " / " + main.getEndLoc().getZ() + " est le spot actuel de remise de l'oeuf.");
        if(main.getAllowNehter()){
            main.setAllowNehter(false);
            p.sendMessage("le nether est désormais fermé");
        }else{
            main.setAllowNehter(true);
            p.sendMessage("le nether est désomrais ouvert");
        }

        return true;
    }
}
