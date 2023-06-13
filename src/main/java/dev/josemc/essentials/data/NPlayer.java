package dev.josemc.essentials.data;

import dev.josemc.essentials.files.YAML;
import dev.josemc.essentials.utils.References;
import org.bukkit.entity.Player;

import java.nio.file.Path;

public class NPlayer {
    YAML file;

    public NPlayer(Player player) {
        file = new YAML(Path.of(References.PLAYERDATA_FOLDER.toString(), player.getUniqueId() + ".yml"));
    }

    public void save() {
        file.set("test", true);
        file.save();
    }

    public void set(String path, Object data) {
        file.set(path, data);
    }
}