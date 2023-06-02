package dev.josemc.essentials.files;

import dev.josemc.essentials.utils.References;

import java.io.File;
import java.nio.file.Path;

public class ConfigurationManager {
    private final YAML settings, lang;

    public ConfigurationManager() {
        settings = new YAML(References.CONFIG_FILE, "settings.yml");
        lang = new YAML(Path.of(References.LANG_FOLDER + File.separator + getSettings().get("General.Lang") + ".yml"), "lang/" + getSettings().get("General.Lang") + ".yml");
    }

    public YAML getSettings() {
        return settings;
    }

    public YAML getLang() {
        return lang;
    }

}
