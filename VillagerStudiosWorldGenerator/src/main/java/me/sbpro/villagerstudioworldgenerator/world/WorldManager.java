package me.sbpro.villagerstudioworldgenerator.world;

import me.sbpro.villagerstudioworldgenerator.Messages;
import me.sbpro.villagerstudioworldgenerator.VillagerStudioWorldGenerator;
import me.sbpro.villagerstudioworldgenerator.generation.VoidChunkGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public final class WorldManager implements Listener {

    private final VillagerStudioWorldGenerator plugin;

    public WorldManager(VillagerStudioWorldGenerator plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        World world = event.getWorld();
        if (!plugin.isManagedWorld(world.getName())) {
            return;
        }

        // Run after the world-load event so the origin chunk can be accessed safely.
        Bukkit.getScheduler().runTask(plugin, () -> setupWorld(world));
    }

    public void setupWorld(World world) {
        if (!plugin.isManagedWorld(world.getName()) || world.getEnvironment() != World.Environment.NORMAL) {
            return;
        }

        // Load only the origin chunk. Never clear existing blocks or terrain.
        world.getChunkAt(0, 0);
        var spawnBlock = world.getBlockAt(0, VoidChunkGenerator.SPAWN_BLOCK_Y, 0);
        if (spawnBlock.getType().isAir()) {
            spawnBlock.setType(Material.BEDROCK, false);
        }

        Location spawn = new Location(
                world,
                0.5,
                VoidChunkGenerator.SPAWN_BLOCK_Y + 1.0,
                0.5
        );
        world.setSpawnLocation(spawn);

        plugin.getLogger().info("Configured void spawn for world '" + world.getName() + "'.");
    }
}
