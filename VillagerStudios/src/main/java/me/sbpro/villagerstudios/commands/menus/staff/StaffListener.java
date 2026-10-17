package me.sbpro.villagerstudios.commands.menus.staff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class StaffListener implements Listener {

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(StaffCommand.TITLE)) {
            return;
        } else {
            event.setCancelled(true);
        }
        
    }
}
