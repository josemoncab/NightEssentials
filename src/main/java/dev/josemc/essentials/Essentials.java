package dev.josemc.essentials;

import dev.josemc.essentials.configurations.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Essentials extends JavaPlugin {

    private static Essentials instance;
    @Override
    public void onEnable() {
        instance = this;
        new FileManager();
    }

    public static Essentials get() {
        return instance;
    }
}
