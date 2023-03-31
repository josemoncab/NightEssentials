package dev.josemc.essentials;

import java.nio.file.Path;

/**
 * Class with basic immutables references
 * */
public final class References {

    /**
     * Utility class
     * */
    private References() {
        throw new UnsupportedOperationException("Utility Class");
    }

    /**
     * Base plugin folder
     * */
    private static final String pluginFolder = Essentials.get().getDataFolder().getPath();

    /**
     * Path of the main config file
     * */
    public static final Path CONFIG_FILE = Path.of(pluginFolder, "settings.conf");

    /**
     * Path of the languages folder
     * */
    public static final Path LANG_FOLDER = Path.of(pluginFolder, "lang/");
}
