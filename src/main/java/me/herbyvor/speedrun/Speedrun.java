package me.herbyvor.speedrun;

import me.herbyvor.speedrun.Commands.*;
import me.herbyvor.speedrun.Guis.TeamSelectionGui;
import me.herbyvor.speedrun.Listeners.*;
import me.herbyvor.speedrun.Misc.EventPlayer;
import me.herbyvor.speedrun.Misc.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public final class Speedrun extends JavaPlugin {

    public Location spawn;
    public Location endLoc;
    public ArrayList<Team> teams = new ArrayList<Team>();
    public ArrayList<EventPlayer> eventPlayers = new ArrayList<EventPlayer>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //register les commandes
        Objects.requireNonNull(getCommand("sr_start")).setExecutor(new StartCommand(this));
        Objects.requireNonNull(getCommand("sr_stop")).setExecutor(new StopCommand(this));
        Objects.requireNonNull(getCommand("sr_pause")).setExecutor(new PauseCommand(this));
        Objects.requireNonNull(getCommand("sr_setEndSpot")).setExecutor(new SetEndSpotCommand(this, this));
        Objects.requireNonNull(getCommand("sr_test")).setExecutor(new TestCommand(this));
        Objects.requireNonNull(getCommand("sr_admin_team")).setExecutor(new AdminTeamCommand());
        Objects.requireNonNull(getCommand("sr_team")).setExecutor(new TeamCommand());
        //cmd de team

        //register les listeners
        PluginManager pm =getServer().getPluginManager();
        pm.registerEvents(new PortalsListener(this), this);
        pm.registerEvents(new JoinListener(this), this);
        pm.registerEvents(new CreeperDropListener(), this);
        pm.registerEvents(new PlaceBlockListener(this), this);
        pm.registerEvents(new PlayerMoveListener(this), this);
        pm.registerEvents(new AchievmentsListener(),this);
        pm.registerEvents(new EndOpennedListener(this), this);

        //set le spawn world
        Block b = Objects.requireNonNull(Bukkit.getWorld("world")).getHighestBlockAt(-171,44);
        spawn = b.getLocation().add(0.5, 1, 0.5);

        //set l'endloc par défaut
        endLoc = new Location(Bukkit.getServer().getWorld("world"), 0.0, 0.0, 0.0);

        //initialise le jeu
        setStarted(false);

        //setup la border
        borderSetup();

        //setup les teams par defaut
        teams.add(new Team("spectateurs", "§7", "§7"));
        teams.add(new Team("rouge", "§c", "§c"));
        teams.add(new Team("bleu", "§9", "§9"));
        teams.add(new Team("vert", "§a", "§a"));
        teams.add(new Team("jaune", "§e", "§e"));

        //setup le keep inv
        setKeepInv(true);

        System.out.println("Speedrun plugin by herbyvor : [On]");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Speedrun plugin by herbyvor : [Off]");
    }

    public Location getEndLoc() {
        return endLoc;
    }

    public void setEndLoc(Location endLoc) {
        this.endLoc = endLoc;
    }

    public boolean isPaused;

    public boolean getPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        this.isPaused = paused;
    }

    public boolean isStarted;

    public boolean getStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        this.isStarted = started;
    }

    public boolean allowNehter;

    public void setAllowNehter(boolean allowNehter) {
        this.allowNehter = allowNehter;
    }

    public boolean getAllowNehter() {
        return allowNehter;
    }

    public boolean allowEnd;

    public boolean getAllowEnd() {
        return allowEnd;
    }

    public void setAllowEnd(boolean allowEnd) {
        this.allowEnd = allowEnd;
    }

    public void borderSetup(){
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setCenter(-171, 44);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setSize(3000);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setDamageAmount(1);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setDamageBuffer(0);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setWarningDistance(2);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setWarningTime(0);
    }

    public EventPlayer getEventPlayersFromPlayer(Player p){
        for(EventPlayer ep : eventPlayers){
            if(ep.getUuid() == p.getUniqueId()){
                System.out.println("player " + p.getDisplayName() + " already exists");
                return ep;
            }
        }
        System.out.println("player " + p.getDisplayName() + " does not exist, creating new instance");
        return new EventPlayer(p.getUniqueId());
    }

    public Team getTeamFromName(String name){
        for(Team t : teams){
            if(t.getName().equals(name)){
                return t;
            }
        }
        if(teams.isEmpty()){
            return null;
        }else{
            return teams.get(0); //spectator
        }
    }

    public void setKeepInv(boolean bool){
        Objects.requireNonNull(Bukkit.getWorld("world")).setGameRule(org.bukkit.GameRule.KEEP_INVENTORY, bool);
        Objects.requireNonNull(Bukkit.getWorld("world_nether")).setGameRule(org.bukkit.GameRule.KEEP_INVENTORY, bool);
        Objects.requireNonNull(Bukkit.getWorld("world_the_end")).setGameRule(org.bukkit.GameRule.KEEP_INVENTORY, bool);
    }

}

