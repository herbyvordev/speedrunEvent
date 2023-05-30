package me.herbyvor.speedrun;

import me.herbyvor.speedrun.Commands.PauseCommand;
import me.herbyvor.speedrun.Commands.StartCommand;
import me.herbyvor.speedrun.Commands.StopCommand;
import me.herbyvor.speedrun.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Speedrun extends JavaPlugin {

    public Location spawn;

    @Override
    public void onEnable() {
        // Plugin startup logic

        //setup la border
        borderSetup();

        //register les commandes
        Objects.requireNonNull(getCommand("sr_start")).setExecutor(new StartCommand(this));
        Objects.requireNonNull(getCommand("sr_stop")).setExecutor(new StopCommand(this));
        Objects.requireNonNull(getCommand("sr_pause")).setExecutor(new PauseCommand(this));


        //register les listeners
        PluginManager pm =getServer().getPluginManager();
        pm.registerEvents(new PortalsListener(this), this);
        pm.registerEvents(new JoinListener(this), this);
        pm.registerEvents(new CreeperDropListener(), this);
        pm.registerEvents(new PlaceBlockListener(this), this);
        pm.registerEvents(new PlayerMoveListener(this), this);

        //set le spawn world
        Block b = Objects.requireNonNull(Bukkit.getWorld("world")).getHighestBlockAt(0,0);
        spawn = b.getLocation().add(0.5, 1, 0.5);

        //initialise le jeu
        setStarted(false);

        System.out.println("Speedrun plugin by herbyvor : [On]");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Speedrun plugin by herbyvor : [Off]");
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
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setSize(6000);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setDamageAmount(1);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setDamageBuffer(0);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setWarningDistance(2);
        Objects.requireNonNull(Bukkit.getWorld("world")).getWorldBorder().setWarningTime(0);
    }
}

