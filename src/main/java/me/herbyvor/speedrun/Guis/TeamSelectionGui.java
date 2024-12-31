package me.herbyvor.speedrun.Guis;

import me.herbyvor.speedrun.Listeners.InventoryClickListener;
import me.herbyvor.speedrun.Misc.EventPlayer;
import me.herbyvor.speedrun.Misc.Team;
import me.herbyvor.speedrun.Misc.Utils;
import me.herbyvor.speedrun.Speedrun;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;

import java.util.Objects;

public class TeamSelectionGui {

    private final static Speedrun main = Speedrun.getPlugin(Speedrun.class);
    private final static Utils utils = new Utils();

    private final Inventory inv = Bukkit.createInventory(null, 9, "§8§l»§r §3Jobs §8§l«§r §8(§fMenu§8)");

    public void initializeItems(EventPlayer p) {
        //oui
        for (int j = 0; j < main.teams.size() - 1; j++) {

            Team team = main.teams.get(j);

            StringBuilder lore = new StringBuilder();

            if(!team.getPlayers().isEmpty()){
                lore.append("§7Joueurs: ");
                for (int i = 0; i < team.getPlayers().size(); i++) {
                    EventPlayer ep = team.getPlayers().get(i);
                    lore.append(ep.getName());
                    if(i != team.getPlayers().size() - 1){
                        lore.append(", ");
                    }
                }
                lore.append("\n");
            }
            lore.append("§7Cliquez pour rejoindre cette équipe");

            ItemStack item = utils.createGuiItem(team.getGuiBlock(), team.getName(), lore.toString());

            if(team == p.getTeam()){
                item.addUnsafeEnchantment(Enchantment.UNBREAKING, 1);
                Objects.requireNonNull(item.getItemMeta()).addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }

            inv.setItem(j, item);

        }
    }

    public void openInventory(final HumanEntity p) {
        //register d'une instance de listener qui observe uniquement CETTE INSTANCE de gui, ouverte par CE PLAYER.
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new InventoryClickListener(inv), main);
        p.openInventory(inv);
    }

}
