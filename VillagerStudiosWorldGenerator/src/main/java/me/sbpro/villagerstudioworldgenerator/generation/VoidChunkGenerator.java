package me.sbpro.villagerstudioworldgenerator.generation;

import me.sbpro.villagerstudioworldgenerator.VillagerStudioWorldGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import java.util.Random;

public final class VoidChunkGenerator extends ChunkGenerator {

    // Fixed Overworld spawn platform height. The player spawn is one block above it.
    public static final int SPAWN_BLOCK_Y = 64;

    private final VillagerStudioWorldGenerator plugin;
    private final String worldName;

    public VoidChunkGenerator(VillagerStudioWorldGenerator plugin, String worldName) {
        this.plugin = plugin;
        this.worldName = worldName;
    }

    @Override
    public void generateNoise(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData chunkData) {
        // Intentionally empty: do not generate terrain.
        // Only the configured world's origin chunk receives the spawn bedrock.
        if (plugin.isManagedWorld(worldName) && chunkX == 0 && chunkZ == 0) {
            if (SPAWN_BLOCK_Y >= chunkData.getMinHeight() && SPAWN_BLOCK_Y < chunkData.getMaxHeight()) {
                chunkData.setBlock(0, SPAWN_BLOCK_Y, 0, Material.BEDROCK);
            }
        }
    }

    @Override
    public boolean shouldGenerateNoise() {
        return false;
    }

    @Override
    public boolean shouldGenerateSurface() {
        return false;
    }

    @Override
    public boolean shouldGenerateCaves() {
        return false;
    }

    @Override
    public boolean shouldGenerateDecorations() {
        return false;
    }

    @Override
    public boolean shouldGenerateMobs() {
        return false;
    }

    @Override
    public boolean shouldGenerateStructures() {
        return false;
    }

    @Override
    public Location getFixedSpawnLocation(World world, Random random) {
        if (!plugin.isManagedWorld(worldName)) {
            return null;
        }
        return new Location(world, 0.5, SPAWN_BLOCK_Y + 1.0, 0.5);
    }
}
