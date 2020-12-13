package fr.spirolad.crafter.data.item.data.item;

import org.bukkit.inventory.ItemStack;

public class ItemRecipeData {

    private int slot;
    private ItemStack itemSlot;

    public ItemRecipeData(int slot, ItemStack itemSlot) {
        this.slot = slot;
        this.itemSlot = itemSlot;
    }

    public int getSlot() {
        return this.slot;
    }

    public ItemStack getItemSlot() {
        return this.itemSlot;
    }

}
