package dev.josemc.essentials.configurations;

import dev.josemc.essentials.utils.References;

public class ConfigurationsManager {

    final Settings settings;

    public ConfigurationsManager() {
        settings = new Settings(References.CONFIG_FILE);
        settings.save();
    }
}
