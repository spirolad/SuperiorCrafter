package fr.spirolad.crafter.data.item.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InteractionPlayer implements Listener {

    public InteractionPlayer() {
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory() != null && event.getClickedInventory().getType() == InventoryType.WORKBENCH) {
            Inventory bench = event.getClickedInventory();
            System.out.println(event.getSlot());
            if (event.getSlot() == 0) {
                event.setCancelled(true);
            }

        }
    }

}
