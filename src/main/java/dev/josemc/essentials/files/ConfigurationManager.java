package dev.josemc.essentials.files;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.utils.References;

import java.io.File;

public class ConfigurationManager {

    private final File pluginFolder = Essentials.get().getDataFolder();

    private YAML settings;

    public ConfigurationManager() {
        settings = new YAML(References.CONFIG_FILE, "settings.yaml");
    }

    public YAML getSettings() {
        return settings;
    }

}
