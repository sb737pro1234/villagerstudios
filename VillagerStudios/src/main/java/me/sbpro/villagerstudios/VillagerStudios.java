package me.sbpro.villagerstudios;

import me.sbpro.villagerstudios.commands.menus.staff.StaffCommand;
import me.sbpro.villagerstudios.commands.menus.staff.StaffListener;
import me.sbpro.villagerstudios.listeners.MainListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerStudios extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Villager Studios enabling.");

        // Main Listener
        getServer().getPluginManager().registerEvents(new MainListener(), this);

        // Staff Command
        getCommand("staff").setExecutor(new StaffCommand());
        getServer().getPluginManager().registerEvents(new StaffListener(), this);


        getLogger().info("Villager Studios enabled.");
    }


    @Override
    public void onDisable() {
        getLogger().info("Villager Studios disabling.");

        getLogger().info("Villager Studios disabled.");
    }
}
