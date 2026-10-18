package me.sbpro.villagerstudios;

import me.sbpro.villagerstudios.commands.menus.staff.StaffCommand;
import me.sbpro.villagerstudios.commands.menus.staff.StaffListener;
import me.sbpro.villagerstudios.listeners.MainListener;
import me.sbpro.villagerstudios.commands.gamemode.*;
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

        // Gamemode Commands
        GameModeCommand gamemode = new GameModeCommand();
        GmcCommand gmc = new GmcCommand();
        GmsCommand gms = new GmsCommand();
        GmaCommand gma = new GmaCommand();
        GmspCommand gmsp = new GmspCommand();
        getCommand("gamemode").setExecutor(gamemode);
        getCommand("gamemode").setTabCompleter(gamemode);
        getCommand("gmc").setExecutor(gmc);
        getCommand("gmc").setTabCompleter(gmc);
        getCommand("gms").setExecutor(gms);
        getCommand("gms").setTabCompleter(gms);
        getCommand("gma").setExecutor(gma);
        getCommand("gma").setTabCompleter(gma);
        getCommand("gmsp").setExecutor(gmsp);
        getCommand("gmsp").setTabCompleter(gmsp);
        getServer().getPluginManager().registerEvents(new GamemodeListener(), this);


        getLogger().info("Villager Studios enabled.");
    }


    @Override
    public void onDisable() {
        getLogger().info("Villager Studios disabling.");

        getLogger().info("Villager Studios disabled.");
    }
}
