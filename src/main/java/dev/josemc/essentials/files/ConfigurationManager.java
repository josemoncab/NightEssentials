package dev.josemc.essentials.files;

import dev.josemc.essentials.utils.References;

import java.io.File;
import java.nio.file.Path;

public class ConfigurationManager {
    private final YAML settings, lang, modules;

    public ConfigurationManager() {
        settings = new YAML(References.CONFIG_FILE, "settings.yml");
        modules = new YAML(References.CONFIG_FILE, "modules.yml");
        // TODO: Check if the lang file exist
        lang = new YAML(Path.of(References.LANG_FOLDER + File.separator + getSettings().get("General.Lang") + ".yml"), "lang/" + getSettings().get("General.Lang") + ".yml");
    }

    public YAML getSettings() {
        return settings;
    }

    public YAML getLang() {
        return lang;
    }

    public YAML getModules() {
        return modules;
    }

}
