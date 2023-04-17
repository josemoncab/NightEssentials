package dev.josemc.essentials.files;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.utils.References;

import java.io.File;
import java.io.IOException;

public class ConfigurationManager {

    private File pluginFolder = Essentials.get().getDataFolder();

    private YamlDocument settings;

    private GeneralSettings generalSettings = GeneralSettings.builder().setKeyFormat(GeneralSettings.KeyFormat.OBJECT).build();
    private LoaderSettings loaderSettings = LoaderSettings.builder().setAutoUpdate(true).build();
    private UpdaterSettings updaterSettings = UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build();

    public ConfigurationManager() {
        Essentials.get().executor.execute(() -> {
            try {
                settings = YamlDocument.create(new File(References.CONFIG_FILE.toUri()), getClass().getResourceAsStream("settings.yml"), generalSettings, loaderSettings, DumperSettings.DEFAULT, updaterSettings);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


}
