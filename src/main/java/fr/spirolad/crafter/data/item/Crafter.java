package fr.spirolad.crafter.data.item;

import fr.spirolad.crafter.data.item.listener.InteractionPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafter extends JavaPlugin {

    private static Crafter instance;

    public Crafter() {
    }

    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new InteractionPlayer(), this);
    }

    public void onDisable() {
    }

    public static Crafter getInstance() {
        return instance;
    }

}
