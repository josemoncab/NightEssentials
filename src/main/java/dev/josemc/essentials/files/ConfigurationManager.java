package dev.josemc.essentials.files;

import dev.josemc.essentials.utils.References;

import java.io.File;
import java.nio.file.Path;

/**
 * Class with all the logic to start using the files
 * */
public class ConfigurationManager {

    /**
     * {@link YAML} of each file we need
     * */
    private final YAML commands, settings, lang;

    /**
     * Constructor to initialize the manager and load the files
     * */
    public ConfigurationManager() {
        settings = new YAML(References.CONFIG_FILE, "settings.yml");
        lang = new YAML(Path.of(References.LANG_FOLDER + File.separator + this.getSettings().get("General.Lang") + ".yml"), "lang/" + this.getSettings().get("General.Lang") + ".yml");
        commands = new YAML(Path.of(References.LANG_FOLDER + File.separator + "commands_" + this.getSettings().get("General.Lang") + ".yml"), "lang/" + "commands_" + this.getSettings().get("General.Lang") + ".yml");
    }

    /**
     * Get the settings.yml file
     * */
    public YAML getSettings() {
        return settings;
    }

    /**
     * Get the lang file used
     * */
    public YAML getLang() {
        return lang;
    }

    /**
     * Get the commands file used
     * */
    public YAML getCommands() {
        return commands;
    }

}
