package me.herbyvor.speedrun.Misc;

import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class Lootchests {

    Speedrun main;

    public Lootchests(Speedrun speedrun){
        this.main = speedrun;
    }

    public void spawnLootChest(String dimension, String valeur){

        Random r = new Random();
        double x = r.nextInt(3000);
        double y = 65 + r.nextInt(100);
        double z = r.nextInt(3000);

        //création du chest
        Location spawnChest = new Location(Bukkit.getWorld(dimension), x, y, z);
        spawnChest.getBlock().setType(Material.CHEST);
        Chest chest = (Chest) spawnChest.getBlock().getState();
        Inventory contenu = chest.getInventory();

        Bukkit.broadcastMessage("§6§lUN COFFRE EST APPARUT EN x : §6" + x + "§4  y : §6" + y + "§4  z : §6" + z + "§4(" + dimension + ")");
        Bukkit.broadcastMessage("§6§l Il s'agit d'un coffre de valeur : " + valeur);

        if (valeur.equalsIgnoreCase("commun")) {
            
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.IRON_INGOT, 16));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLD_NUGGET, 7));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SADDLE));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SUGAR_CANE, 30));
            if (Math.random() * 100 < 50) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.TNT, 2)); }
            if (Math.random() * 100 < 40) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.TNT, 2)); }
            if (Math.random() * 100 < 30) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.TNT, 2)); }

            if (Math.random() * 100 < 80) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.IRON_NUGGET, 5));
            }
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLD_BLOCK, 1));
            if (Math.random() * 100 < 70) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.LEATHER_HORSE_ARMOR, 1));
            }
            if (Math.random() * 100 < 50) {
                ItemStack p4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                p4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                contenu.setItem(r.nextInt(contenu.getSize()), p4);
            } else {
                ItemStack f4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                f4.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 3);
                contenu.setItem(r.nextInt(contenu.getSize()), f4);
            }
            if (Math.random() * 100 < 50) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLD_BLOCK, 1));
            }
            if (Math.random() * 100 < 50) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 1));
            }
            if (Math.random() * 100 < 50) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 1));
            }
            if (Math.random() * 100 < 5) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.NETHERITE_SCRAP, 1));
            }
            if (Math.random() * 100 < 5) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.NETHERITE_SCRAP, 1));
            }

        } else if (valeur.equalsIgnoreCase("rare")) {

            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 2));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 2));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.IRON_INGOT, 24));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLD_BLOCK, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SADDLE));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.EXPERIENCE_BOTTLE, 16));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SUGAR_CANE, 30));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SUGAR_CANE, 18));
            if (Math.random() * 100 < 50) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.TNT, 2)); }
            if (Math.random() * 100 < 40) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.TNT, 2)); }
            if (Math.random() * 100 < 30) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.TNT, 2)); }

            if (Math.random() * 100 < 80) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.FLINT, 1));
            }
            if (Math.random() * 100 < 80) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.IRON_NUGGET, 5));
            }

            if (Math.random() * 100 < 70) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.IRON_HORSE_ARMOR, 1));
            }
            if (Math.random() * 100 < 70) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLDEN_APPLE, 1));
            }
            if (Math.random() * 100 < 60) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLDEN_APPLE, 1));
            }
            if (Math.random() * 100 < 50) {
                ItemStack s1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                s1.addUnsafeEnchantment(Enchantment.MULTISHOT, 1);
                contenu.setItem(r.nextInt(contenu.getSize()), s1);
            }else{
                ItemStack s1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                s1.addUnsafeEnchantment(Enchantment.PIERCING, 4);
                contenu.setItem(r.nextInt(contenu.getSize()), s1);
            }
            if (Math.random() * 100 < 40) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3));
            }
            if (Math.random() * 100 < 40) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 2));
            }
            if (Math.random() * 100 < 10) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
            }
            if (Math.random() * 100 < 5) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.NETHERITE_SCRAP, 1));
            }
            if (Math.random() * 100 < 5) {
                contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.NETHERITE_SCRAP, 1));
            }
        }else if(valeur.equalsIgnoreCase("légendaire")) {

            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLD_NUGGET, 3));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SADDLE));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.EXPERIENCE_BOTTLE, 16));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SUGAR_CANE, 30));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SUGAR_CANE, 18));
            contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.SUGAR_CANE, 9));

            if (Math.random() * 100 < 80) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.FLINT, 3)); }
            if (Math.random() * 100 < 80) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.FLINT, 3)); }
            if (Math.random() * 100 < 80) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.IRON_NUGGET, 5)); }

            if (Math.random() * 100 < 70) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLDEN_APPLE, 1)); }
            if (Math.random() * 100 < 50) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLDEN_APPLE, 1)); }
            if (Math.random() * 100 < 30) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLDEN_APPLE, 1)); }
            if (Math.random() * 100 < 10) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.GOLDEN_APPLE, 1)); }

            ItemStack tu3 = new ItemStack(Material.TRIDENT, 1);
            tu3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
            tu3.addUnsafeEnchantment(Enchantment.LOYALTY, 1);
            contenu.setItem(r.nextInt(contenu.getSize()), tu3);

            if (Math.random() * 100 < 50) {
                ItemStack s1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                s1.addUnsafeEnchantment(Enchantment.MULTISHOT, 1);
                contenu.setItem(r.nextInt(contenu.getSize()), s1);
            }else{
                ItemStack s1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                s1.addUnsafeEnchantment(Enchantment.PIERCING, 4);
                contenu.setItem(r.nextInt(contenu.getSize()), s1);
            }

            if (Math.random() * 100 < 50) {
                ItemStack p4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                p4.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                contenu.setItem(r.nextInt(contenu.getSize()), p4);
            } else {
                ItemStack f4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
                f4.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 3);
                contenu.setItem(r.nextInt(contenu.getSize()), f4);
            }

            if (Math.random() * 100 < 60) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 3)); }
            if (Math.random() * 100 < 50) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 2)); }
            if (Math.random() * 100 < 40) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.DIAMOND, 1)); }
            if (Math.random() * 100 < 20) { contenu.setItem(r.nextInt(contenu.getSize()), new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1)); }
        }
    }

}
