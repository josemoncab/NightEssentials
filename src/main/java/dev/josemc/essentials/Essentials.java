package dev.josemc.essentials;

import dev.josemc.essentials.files.ConfigurationManager;
import org.bukkit.plugin.java.JavaPlugin;

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
     * Queue used to execute heavy task like file handling
     * */
    public Executor executor;

    @Override
    public void onEnable() {
        instance = this;
        executor = Executors.newSingleThreadExecutor();

        configurationsManager = new ConfigurationManager();
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
}
