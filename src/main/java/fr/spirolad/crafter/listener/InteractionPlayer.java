package fr.spirolad.crafter.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InteractionPlayer implements Listener {



    @EventHandler
    public void onClick(InventoryClickEvent event){
        // Check if the inventory is a workbench
        if(event.getClickedInventory() == null || event.getClickedInventory().getType() != InventoryType.WORKBENCH) return;
        Inventory bench = event.getClickedInventory();
        System.out.println(event.getSlot());
        if(event.getSlot() == 0){
            event.setCancelled(true);
            
        }
    }

}
