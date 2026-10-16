package me.sbpro.villagerstudioworldgenerator.commands;

import me.sbpro.villagerstudioworldgenerator.Messages;
import me.sbpro.villagerstudioworldgenerator.VillagerStudioWorldGenerator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class ReloadCommand implements CommandExecutor, TabCompleter {

    private final VillagerStudioWorldGenerator plugin;

    public ReloadCommand(VillagerStudioWorldGenerator plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("villagerstudioworldgenerator.admin")) {
            Messages.error(sender, Messages.noPermission());
            return true;
        }

        if (args.length != 1 || !args[0].equalsIgnoreCase("reload")) {
            Messages.send(sender, Messages.reloadUsage());
            return true;
        }

        plugin.reloadPluginConfiguration();
        Messages.send(sender, Messages.reloadSuccess());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
                                               @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1 && sender.hasPermission("villagerstudioworldgenerator.admin")) {
            return List.of("reload").stream()
                    .filter(value -> value.startsWith(args[0].toLowerCase()))
                    .toList();
        }
        return List.of();
    }
}
