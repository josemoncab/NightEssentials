package dev.josemc.essentials.commands;

import revxrsal.commands.locales.LocaleReader;

import java.util.Locale;

/*
* TODO: Create a YAML locale reader to customize the messages in lamp
* */

public class YAMLLocaleProvider implements LocaleReader {

    @Override
    public boolean containsKey(String key) {
        return false;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
