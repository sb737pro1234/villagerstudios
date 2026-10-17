package me.sbpro.villagerstudios;

import me.sbpro.villagerstudios.listeners.MainListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerStudios extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Villager Studios enabling.");

        getServer().getPluginManager().registerEvents(new MainListener(), this);

        getLogger().info("Villager Studios enabled.");
    }


    @Override
    public void onDisable() {
        getLogger().info("Villager Studios disabling.");

        getLogger().info("Villager Studios disabled.");
    }
}
