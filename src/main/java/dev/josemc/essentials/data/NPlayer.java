package dev.josemc.essentials.data;

import dev.josemc.essentials.files.YAML;
import dev.josemc.essentials.utils.References;
import org.bukkit.entity.Player;

import java.nio.file.Path;

/**
 * Class used for store per player related information
 * */
public class NPlayer {
    YAML file;

    public NPlayer(Player player) {
        file = new YAML(Path.of(References.PLAYERDATA_FOLDER.toString(), player.getUniqueId() + ".yml"));
    }

    /**
     * Save the player file
     * */
    public void save() {
        file.save();
    }

    /**
     * Set new data to the player's file
     *
     * @param path Path in the yaml
     * @param data Data to set
     * */
    public void set(String path, Object data) {
        file.set(path, data);
    }
}
