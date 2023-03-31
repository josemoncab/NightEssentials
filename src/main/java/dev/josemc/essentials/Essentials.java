package dev.josemc.essentials;

import dev.josemc.essentials.configurations.Settings;
import dev.josemc.essentials.utils.References;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.objectmapping.meta.NodeResolver;
import org.spongepowered.configurate.util.NamingScheme;
import org.spongepowered.configurate.util.NamingSchemes;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Essentials extends JavaPlugin {

    private static Essentials instance;

    Settings settigns;

    public static ObjectMapper.Factory OBJECTMAPPER_FACTORY = ObjectMapper.factoryBuilder().defaultNamingScheme((NamingScheme) NamingSchemes.PASSTHROUGH).addNodeResolver(NodeResolver.onlyWithSetting()).build();

    public Executor executor;
    @Override
    public void onEnable() {
        instance = this;
        // FileManager();
        executor = Executors.newSingleThreadExecutor();

        settigns = new Settings(References.CONFIG_FILE);
        settigns.save();
        System.out.println(settigns.getData().warps.test);
    }

    public static Essentials get() {
        return instance;
    }
}
