package fr.spirolad.crafter;

import fr.spirolad.crafter.listener.InteractionPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class Crafter extends JavaPlugin {

    private static Crafter instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new InteractionPlayer(), this);

    }

    @Override
    public void onDisable() {

    }

    public static Crafter getInstance() { return instance; }
}
