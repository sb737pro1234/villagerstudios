package me.sbpro.villagerstudios.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {


    private int uniquePlayers = Bukkit.getOfflinePlayers().length;

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) {
            event.setJoinMessage("§8[§a+§8]§f " + player.getName());
            return;
        }

        uniquePlayers++;
        event.setJoinMessage("§8[§6+§8]§f " + player.getName() + " (§6" + uniquePlayers + "§f) has joined for the first time!");
    }


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§8[§c-§8]§f " + player.getName());
    }

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
        event.message(null);
    }

}