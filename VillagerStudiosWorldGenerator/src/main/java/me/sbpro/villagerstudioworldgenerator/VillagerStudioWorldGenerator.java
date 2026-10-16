package me.sbpro.villagerstudioworldgenerator;

import me.sbpro.villagerstudioworldgenerator.commands.ReloadCommand;
import me.sbpro.villagerstudioworldgenerator.generation.VoidChunkGenerator;
import me.sbpro.villagerstudioworldgenerator.world.WorldManager;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public final class VillagerStudioWorldGenerator extends JavaPlugin {

    private volatile Set<String> managedWorlds = Set.of();
    private WorldManager worldManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadWorldList();

        this.worldManager = new WorldManager(this);
        getServer().getPluginManager().registerEvents(worldManager, this);

        if (getCommand("vswg") != null) {
            getCommand("vswg").setExecutor(new ReloadCommand(this));
        }

        // Apply the spawn setup to configured worlds that are already loaded.
        for (World world : getServer().getWorlds()) {
            if (isManagedWorld(world.getName())) {
                worldManager.setupWorld(world);
            }
        }

        getLogger().info("VillagerStudioWorldGenerator enabled. Managed worlds: " + managedWorlds);
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        // Multiverse-Core resolves this generator using the plugin name.
        return new VoidChunkGenerator(this, worldName);
    }

    public void reloadWorldList() {
        reloadConfig();
        this.managedWorlds = getConfig().getStringList("worlds").stream()
                .map(name -> name.toLowerCase(Locale.ROOT))
                .collect(Collectors.toUnmodifiableSet());
    }

    public boolean isManagedWorld(String worldName) {
        return managedWorlds.contains(worldName.toLowerCase(Locale.ROOT));
    }

    public WorldManager getWorldManager() {
        return worldManager;
    }

    public void reloadPluginConfiguration() {
        reloadWorldList();
        if (worldManager != null) {
            for (World world : getServer().getWorlds()) {
                if (isManagedWorld(world.getName())) {
                    worldManager.setupWorld(world);
                }
            }
        }
    }
}
