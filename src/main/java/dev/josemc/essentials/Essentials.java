package dev.josemc.essentials;

import dev.josemc.essentials.commands.CommandManager;
import dev.josemc.essentials.data.DataManager;
import dev.josemc.essentials.files.ConfigurationManager;
import dev.josemc.essentials.listeners.JoinListener;
import dev.josemc.essentials.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Essentials extends JavaPlugin {

    /**
     * Instance of the plugin
     * */
    private static Essentials instance;

    /**
     * Instance of ConfigurationManager
     * */
    private static ConfigurationManager configurationsManager;

    /**
     * Instance of the DataManager
     * */
    private static DataManager dataManager;

    @Override
    public void onEnable() {
        instance = this;

        configurationsManager = new ConfigurationManager();
        dataManager = new DataManager();

        new CommandManager();

        registerEvents();
    }

    @Override
    public void onDisable() {
        dm().clearCache();
    }

    /**
     * Method used for register all event listeners
     * Probably substituted for an EventManager and Reflections
     * */
    private void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeaveListener(), this);
    }

    /**
     * Get the instance of the plugin
     *
     * @return instance of the {@link Essentials}
     * */
    public static Essentials get() {
        return instance;
    }

    /**
     * Get the configuration manager instance
     *
     * @return instance of the {@link ConfigurationManager}
     * */
    public static ConfigurationManager cm() {
        return configurationsManager;
    }

    /**
     * Get the data manager instance
     *
     * @return instance of the {@link DataManager}
     * */
    public static DataManager dm() {
        return dataManager;
    }
}
