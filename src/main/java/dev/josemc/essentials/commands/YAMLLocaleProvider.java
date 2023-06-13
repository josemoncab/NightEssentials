package dev.josemc.essentials.commands;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.files.YAML;
import dev.josemc.essentials.utils.References;
import revxrsal.commands.locales.LocaleReader;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;

/*
* TODO: Create a YAML locale reader to customize the messages in lamp
* */

public class YAMLLocaleProvider implements LocaleReader {

    private final YAML yaml;
    private final Locale locale;

    public YAMLLocaleProvider(YAML file, Locale locale) {
        this.yaml = new YAML(Path.of(References.LANG_FOLDER + File.separator + Essentials.cm().getSettings().get("General.Lang") + ".yml"), "lang/" + Essentials.cm().getSettings().get("General.Lang") + ".yml");
        this.locale = locale;
    }

    @Override
    public boolean containsKey(String key) {
        return yaml.contains(key);
    }

    @Override
    public String get(String key) {
        return (String) yaml.get(key);
    }

    @Override
    public Locale getLocale() {
        return locale;
    }
}
