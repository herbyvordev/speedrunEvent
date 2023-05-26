package me.herbyvor.speedrun;

import me.herbyvor.speedrun.Commands.StartCommand;
import me.herbyvor.speedrun.Listeners.PortalsListener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Speedrun extends JavaPlugin {

    public Location spawn = new Location(Bukkit.getWorld("world"), 0, 80, 0);

    @Override
    public void onEnable() {
        // Plugin startup logic

        //setup la border
        borderSetup();

        //register les commandes
        Objects.requireNonNull(getCommand("start")).setExecutor(new StartCommand(this));

        //register les listeners
        PluginManager pm =getServer().getPluginManager();
        pm.registerEvents(new PortalsListener(this), this);

        //initialise le jeu
        setStarted(false);

        System.out.println("Speedrun plugin by herbyvor : [On]");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Speedrun plugin by herbyvor : [Off]");
    }

    public boolean isStarted;

    public boolean getStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
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

