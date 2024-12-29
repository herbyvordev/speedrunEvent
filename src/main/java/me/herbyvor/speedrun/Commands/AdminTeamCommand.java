package me.herbyvor.speedrun.Commands;

import me.herbyvor.speedrun.Misc.Team;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminTeamCommand implements CommandExecutor {

    private static final Speedrun main = Speedrun.getPlugin(Speedrun.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player p = null;
        if (commandSender instanceof Player) {
            p = (Player) commandSender;
        }
        if(p == null){
            System.out.println("Cette commande doit être executée par un joueur ingame !"); //a changer ? flm ?
            return true;
        }
        if (!p.isOp()) {
            p.sendMessage("t'a pas la perm");
            return true;
        }

        if (strings.length == 0) {
            p.sendMessage("§cUtilisation: /adminteam <create/remove/list>");
            return true;
        }

        if (strings[0].equalsIgnoreCase("create")) {
            if (strings.length == 1) {
                p.sendMessage("§cUtilisation: /adminteam create <nom> <code couleur>");
                return true;
            }

            main.teams.add(new Team(strings[1], strings[2]));

            return true;

        }else if(strings[0].equalsIgnoreCase("remove")) {

            if (strings.length == 1) {
                p.sendMessage("§cUtilisation: /adminteam remove <nom>");
                return true;
            }

            try{

                Team team = main.getTeamFromName(strings[1]);
                team.DisbandTeam();
                main.teams.remove(team);

            }catch (NullPointerException e){
                p.sendMessage("§cL'équipe n'existe pas !");
            }catch (Exception e){
                p.sendMessage("§cUtilisation: /adminteam remove <nom>");
            }


            return true;

        }else if(strings[0].equalsIgnoreCase("list")) {

            StringBuilder msg = new StringBuilder("Liste des équipes : \n");

            for (Team team : main.teams) {
                msg.append(team.getPrefix()).append(team.getName()).append(", \n");
            }

            p.sendMessage(msg.toString());

            return true;
        }

        return true;
    }
}
