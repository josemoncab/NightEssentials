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

    private static ConfigurationManager cm;

    public Executor executor;
    @Override
    public void onEnable() {
        instance = this;
        executor = Executors.newSingleThreadExecutor();

        cm = new ConfigurationManager();
    }

    public static Essentials get() {
        return instance;
    }

    public static ConfigurationManager getCm() {
        return cm;
    }
}
