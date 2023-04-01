package dev.josemc.essentials.configurations;

import dev.josemc.essentials.Essentials;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;

public class Settings {
    private final HoconConfigurationLoader loader;

    private CommentedConfigurationNode root;

    private final ObjectMapper<SettingsData> configMapper;

    private SettingsData data;

    public Settings(Path path) {
        try {
            if (Files.notExists(path.getParent()))
                Files.createDirectories(path.getParent());
            if (Files.notExists(path))
                Files.createFile(path);
            this.loader = HoconConfigurationLoader.builder().path(path).build();
            this.configMapper = Essentials.OBJECTMAPPER_FACTORY.get(SettingsData.class);
            if (reload())
                save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SettingsData getData() {
        return this.data;
    }

    public void save() {
        Essentials.get().executor.execute(() -> {
            try {
                this.configMapper.save(this.data, this.root);
                this.loader.save(this.root);
            } catch (IOException e) {
                Essentials.get().getLogger().log(Level.SEVERE, "Failed to save configuration", e);
            }
        });
    }

    public boolean reload() {
        try {
            this.root = this.loader.load();
            this.data = this.configMapper.load(this.root);
        } catch (Exception e) {
            Essentials.get().getLogger().log(Level.SEVERE, "Failed to load configuration", e);
            return false;
        }
        return true;
    }
}
