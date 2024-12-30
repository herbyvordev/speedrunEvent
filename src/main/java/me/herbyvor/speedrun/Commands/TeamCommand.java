package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Guis.TeamSelectionGui;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamCommand implements CommandExecutor {

    private static final Speedrun main = Speedrun.getPlugin(Speedrun.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = null;
        if (commandSender instanceof Player) {
            p = (Player) commandSender;
            if (!p.isOp()) {
                p.sendMessage("lmao t'as pas la perm");
                return true;
            }
        }
        if (p == null) {
            System.out.println("Cette commande doit être executée par un joueur ingame !");
            return true;
        }

        if (strings.length > 0) {
            p.sendMessage("§cUtilisation: /team");
            return true;
        }

        TeamSelectionGui teamSelectionGui = new TeamSelectionGui();

        teamSelectionGui.initializeItems(main.getEventPlayersFromPlayer(p));
        teamSelectionGui.openInventory(p);

        return true;
    }
}
