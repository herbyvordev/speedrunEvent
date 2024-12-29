package me.herbyvor.speedrun.Listeners;

import me.herbyvor.speedrun.Misc.EventPlayer;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    Speedrun main;
    public JoinListener(Speedrun speedrun){
        this.main = speedrun;
    }


    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        System.out.println("Le joueur " + p.getDisplayName() + " viens de rejoindre le serveur.");

        if(!main.getStarted()){
            p.teleport(main.spawn);
            p.setGameMode(GameMode.ADVENTURE);
            p.setInvulnerable(true);
            p.setFoodLevel(20);
            p.setHealth(20);

            //get or create eventPlayer instance
            EventPlayer ep = main.getEventPlayersFromPlayer(p);
            if(ep.getTeam() == null){
                ep.setTeam("spectator");
                p.sendMessage("Vous n'avez pas d'équipe ! /team");
            }
        }else {
            if(p.getGameMode() != GameMode.SURVIVAL){
                p.setGameMode(GameMode.SURVIVAL);
            }
        }
    }


}
