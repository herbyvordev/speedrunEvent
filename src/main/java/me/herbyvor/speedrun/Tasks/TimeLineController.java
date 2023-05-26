package me.herbyvor.speedrun.Tasks;

import me.herbyvor.speedrun.Misc.Lootchests;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.Random;

public class TimeLineController extends BukkitRunnable {

    Speedrun main;

    public TimeLineController(Speedrun speedrun){
        this.main = speedrun;
    }

    private int secondes = 0;
    public int minutes = 0;

    @Override
    public void run() {


        //initialisation
        if(minutes == 0 && secondes == 0){
            //accès au nether :
            main.setAllowNehter(false);
            //accès a l'end :
            main.setAllowEnd(false);
        }

        //allowNether
        if(minutes == 30 && secondes == 0){
            main.setAllowNehter(true);
            Bukkit.broadcastMessage("§aL'accès au nether est désormais autorisé !");
        }

        //allowEnd
        if(minutes == 50 && secondes == 0){
            main.setAllowEnd(true);
            Bukkit.broadcastMessage("§aL'accès à l'end est désormais autorisé !");
        }

        //lootchests
        if(minutes == 10 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "commun");
        }
        if(minutes == 20 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "rare");
        }
        if(minutes == 35 && secondes == 0){
            new Lootchests(main).spawnLootChest("nether", "commun");
        }
        if(minutes == 45 && secondes == 0){
            new Lootchests(main).spawnLootChest("nether", "rare");
            new Lootchests(main).spawnLootChest("world", "rare");
        }
        if(minutes == 60 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "légendaire");
        }
        if(minutes == 80 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "rare");
        }
        if(minutes == 90 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "commun");
        }
        if(minutes == 105 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "légendaire");
        }
        if(minutes == 120 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "rare");
        }
        if(minutes == 150 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "commun");
        }
        if(minutes == 180 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "rare");
        }
        if(minutes == 210 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "commun");
        }
        if(minutes == 240 && secondes == 0){
            new Lootchests(main).spawnLootChest("world", "légendaire");
            Bukkit.broadcastMessage("§4Il s'agissait du dernier lootchest !");
        }

        //incrémentation
        secondes ++;
        if(secondes == 59){
            minutes ++;
            secondes = 0;
        }

        if(!main.getStarted()){
            System.out.println("Le jeu a duré " + minutes + " minutes et " + secondes + " secondes. gg!");
            cancel();
        }

    }
}