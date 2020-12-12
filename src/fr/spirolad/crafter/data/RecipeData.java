package fr.spirolad.crafter.data;

import fr.spirolad.crafter.Crafter;
import fr.spirolad.crafter.data.item.ItemRecipeData;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeData {

    // Constant to create a recipe

    private static final char[] IDITEMRECIPE = new char[]{'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private static final String TOPLINE = "123", MIDLINE = "456", BOTTOMLINE = "789";

    // Variable of the object

    private ItemRecipeData[] itemRecipe;
    private ItemStack result;
    private final String name;
    private boolean checkName;
    private boolean checkDescription;

    /**
     *
     * @param result item result of the new craft
     * @param name craft name,
     * @param itemRecipe all item need to the new craft
     */

    public RecipeData(ItemStack result, String name, ItemRecipeData... itemRecipe) { // https://bukkit.org/threads/check-if-item-is-in-crafting-recepie.394884/ Check it
        this.result = result;
        this.name = name;
        this.itemRecipe = itemRecipe;

        // Every line of the craft
        String[] line = new String[]{TOPLINE, MIDLINE, BOTTOMLINE};
        NamespacedKey key = new NamespacedKey(Crafter.getInstance(), name);
        ShapedRecipe shapedRecipe = new ShapedRecipe(key, result);

        // Table of item in order
        ItemRecipeData[] itemOrder = new ItemRecipeData[9];

        // put in order all item
        for(ItemRecipeData itemRecipeData : itemRecipe){
            if(itemRecipeData == null) return;
            itemOrder[itemRecipeData.getSlot() - 1] = itemRecipeData;
        }

        // Create the string of the recipe
        for(int i = 1; i < 10; i++){
            ItemRecipeData itemSlot =  itemOrder[i - 1];
            String lineString = line[getLine(i)];
            line[getLine(i)] = lineString.replace(String.valueOf(i), (itemSlot == null) ? " " : String.valueOf(IDITEMRECIPE[i - 1]));
        }

        // Add the recip in the object
        shapedRecipe.shape(line[0], line[1], line[2]);

        // distribute all id to the item
        for (int i = 0; i < itemRecipe.length; i++) {
            if(itemOrder[i] == null) continue;
            shapedRecipe.setIngredient(IDITEMRECIPE[i], itemOrder[i].getItemSlot().getType());
        }

        // Add the recipe in spigot
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    /**
     * @param i item slot
     * @return the object line
     */

    private int getLine(int i){
        if(i >= 1 && i <= 3) return 0;
        else if(i >= 4 && i <= 6) return 1;
        if(i >= 7 && i <= 9) return 2;
        return -1;
    }

    /**
     * @return item craft name
     * */

    public String getName() { return name; }

    /**
     * @return all item need to craft
     */

    public ItemRecipeData[] getItemRecipe() { return itemRecipe; }

    /**
     * @return item craft result
     */

    public ItemStack getResult() { return result; }
}
