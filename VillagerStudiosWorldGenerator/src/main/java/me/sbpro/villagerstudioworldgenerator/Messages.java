package me.sbpro.villagerstudioworldgenerator;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public final class Messages {

    public static final String PREFIX = "§2§lVILLAGER STUDIOS §8» §f";
    public static final String WHITE = "§f";
    public static final String CUSTOM = "§x§7§C§F§C§6§A";
    public static final String ERROR = "§c";

    private Messages() {
    }

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + message);
    }

    public static void error(CommandSender sender, String message) {
        sender.sendMessage(PREFIX + ERROR + message);
    }

    public static String reloadSuccess() {
        return CUSTOM + "Configuration reloaded.";
    }

    public static String reloadUsage() {
        return WHITE + "Usage: " + CUSTOM + "/vswg reload";
    }

    public static String noPermission() {
        return ERROR + "You do not have permission to do this.";
    }
}
