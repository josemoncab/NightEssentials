package dev.josemc.essentials;

import dev.josemc.essentials.commands.TestCommand;
import dev.josemc.essentials.commands.YAMLLocaleProvider;
import dev.josemc.essentials.data.DataManager;
import dev.josemc.essentials.files.ConfigurationManager;
import dev.josemc.essentials.files.YAML;
import dev.josemc.essentials.listeners.JoinListener;
import dev.josemc.essentials.listeners.LeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Essentials extends JavaPlugin {

    /**
     * Instance of the plugin
     * */
    private static Essentials instance;

    /**
     * Instance of ConfigurationsManager
     * */
    private static ConfigurationManager configurationsManager;

    /**
     * Instance of the DataManager
     * */
    private static DataManager dataManager;

    /**
     * Queue used to execute heavy task like file handling
     * */
    public Executor executor;

    @Override
    public void onEnable() {
        instance = this;
        executor = Executors.newSingleThreadExecutor();

        configurationsManager = new ConfigurationManager();
        dataManager = new DataManager();

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        dm().clearCache();
    }

    private void registerEvents() {
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeaveListener(), this);
    }

    private void registerCommands() {
        BukkitCommandHandler commandHandler = BukkitCommandHandler.create(this);
        commandHandler.enableAdventure();
        commandHandler.register(new TestCommand());
        commandHandler.registerBrigadier();
        commandHandler.getTranslator().add(new YAMLLocaleProvider(, Locale.forLanguageTag("es_es")));
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
