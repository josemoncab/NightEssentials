package dev.josemc.essentials.files;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.route.Route;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import dev.josemc.essentials.Essentials;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Class used for management of a single yaml file
 * */
public class YAML {

    /**
     * The YAML document associated with the file
     * */
    private YamlDocument document;

    /**
     * Default settings used for the YAMLDocument creator
     * */
    private final GeneralSettings generalSettings = GeneralSettings.builder().setKeyFormat(GeneralSettings.KeyFormat.OBJECT).build();

    /**
     * Default settings used for the YAMLDocument creator
     * */
    private final LoaderSettings loaderSettings = LoaderSettings.builder().setAutoUpdate(true).build();

    /**
     * Default settings used for the YAMLDocument creator
     * */
    private final UpdaterSettings updaterSettings = UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build();

    /**
     * Create a YAML file with default content. Used for configuration files
     *
     * @param path Path of the file
     * @param internal Path of the file inside jar to use at default values
     * */
    public YAML(Path path, String internal) {
        this(path, internal, true);
    }

    /**
     * Create a YAML file empty. Used for data storage
     *
     * @param path Path of the file
     * */
    public YAML(Path path) {
        this(path, null, false);
    }

    /**
     * Create a YAML file based on the use.
     *
     * @param path Path of the file
     * @param internal Path of the file inside jar to use at default values
     * @param autoUpdate Should the file auto update with new default values
     * */
    private YAML(Path path, String internal, boolean autoUpdate) {
        Essentials.get().executor.execute(() -> {
            try {
                document = YamlDocument.create(new File(path.toUri()), getClass().getResourceAsStream(internal), generalSettings, LoaderSettings.builder().setAutoUpdate(autoUpdate).build(), DumperSettings.DEFAULT, updaterSettings);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Get the value from the path
     *
     * @return Value in the path
     * */
    public Object get(String path) {
        return document.get(Route.fromString(path));
    }

    /**
     * Save the file
     * */
    public void save() {
        Essentials.get().executor.execute(() -> {
            try {
                document.save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Reload the file
     * */
    public void reload() {
        Essentials.get().executor.execute(() -> {
            try {
                document.reload();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
