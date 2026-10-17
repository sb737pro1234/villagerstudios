package me.sbpro.villagerstudios.commands.menus.staff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class StaffCommand implements CommandExecutor {

    public static final String TITLE = "§6Staff";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)){
            sender.sendMessage("§cYou must be a player to use this command.");
        } else {
            Inventory staff = Bukkit.createInventory(null, 9, TITLE);


            ItemStack justavillager87 = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta justavillager87ItemMeta = (SkullMeta) justavillager87.getItemMeta();
            justavillager87ItemMeta.setPlayerProfile(Bukkit.createProfile(UUID.fromString("9bd7bd7c-0d0b-481d-b7da-83137cb82770"), "JustAVillager87"));
            justavillager87ItemMeta.setDisplayName("§6§lOwner§f JustAVillager87");
            justavillager87.setItemMeta(justavillager87ItemMeta);
            staff.setItem(0, justavillager87);

            ItemStack sb737pro1234 = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta sb737pro1234ItemMeta= (SkullMeta) sb737pro1234.getItemMeta();
            sb737pro1234ItemMeta.setPlayerProfile(Bukkit.createProfile(UUID.fromString("699b0b07-a5f6-4028-ab24-e1f53a2a5237"), "SB737Pro1234"));
            sb737pro1234ItemMeta.setDisplayName("§3§lDeveloper§f SB737Pro1234");
            sb737pro1234.setItemMeta(sb737pro1234ItemMeta);
            staff.setItem(1, sb737pro1234);

            player.openInventory(staff);
        }


        return true;
    }
}
