package dev.josemc.essentials;

import dev.josemc.essentials.configurations.ConfigurationsManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.objectmapping.meta.NodeResolver;
import org.spongepowered.configurate.util.NamingSchemes;

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
    private static ConfigurationsManager configurationsManager;

    /**
     * Global ObjectMapper for all files
     * */
    public static ObjectMapper.Factory OBJECTMAPPER_FACTORY = ObjectMapper.factoryBuilder().defaultNamingScheme(NamingSchemes.PASSTHROUGH).addNodeResolver(NodeResolver.onlyWithSetting()).build();

    public Executor executor;
    @Override
    public void onEnable() {
        instance = this;
        executor = Executors.newSingleThreadExecutor();

        configurationsManager = new ConfigurationsManager();
    }

    public static Essentials get() {
        return instance;
    }

    public static ConfigurationsManager cm() {
        return configurationsManager;
    }
}
