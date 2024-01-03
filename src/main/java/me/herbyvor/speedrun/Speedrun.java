package me.herbyvor.speedrun;

import me.herbyvor.speedrun.Commands.*;
import me.herbyvor.speedrun.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Speedrun extends JavaPlugin {

    public Location spawn;
    public Location endLoc;

    @Override
    public void onEnable() {
        // Plugin startup logic

        //setup la border
        borderSetup();

        //register les commandes
        Objects.requireNonNull(getCommand("sr_start")).setExecutor(new StartCommand(this));
        Objects.requireNonNull(getCommand("sr_stop")).setExecutor(new StopCommand(this));
        Objects.requireNonNull(getCommand("sr_pause")).setExecutor(new PauseCommand(this));
        Objects.requireNonNull(getCommand("sr_setEndSpot")).setExecutor(new SetEndSpotCommand(this, this));
        Objects.requireNonNull(getCommand("sr_test")).setExecutor(new TestCommand(this));

        //register les listeners
        PluginManager pm =getServer().getPluginManager();
        pm.registerEvents(new PortalsListener(this), this);
        pm.registerEvents(new JoinListener(this), this);
        pm.registerEvents(new CreeperDropListener(), this);
        pm.registerEvents(new PlaceBlockListener(this), this);
        pm.registerEvents(new PlayerMoveListener(this), this);
        pm.registerEvents(new AchievmentsListener(),this);

        //set le spawn world
        Block b = Objects.requireNonNull(Bukkit.getWorld("world")).getHighestBlockAt(-49,37);
        spawn = b.getLocation().add(0.5, 1, 0.5);

        //set l'endloc par défaut
        endLoc = new Location(Bukkit.getServer().getWorld("world"), 0.0, 0.0, 0.0);

        //initialise le jeu
        setStarted(false);

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
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setCenter(0, 0);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setSize(3000);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setDamageAmount(1);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setDamageBuffer(0);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setWarningDistance(2);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setWarningTime(0);
    }

}

