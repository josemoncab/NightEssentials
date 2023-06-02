package dev.josemc.essentials.data;

import dev.josemc.essentials.utils.References;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class DataManager {

    private final HashMap<UUID, NPlayer> playersCache = new HashMap<>();

    public DataManager() {
        File folder = new File(References.PLAYERDATA_FOLDER.toUri());

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    /**
     * Load player into cache. If the player don't have a file yet, create a new one.
     * */
    public void loadPlayer(Player player) {
        playersCache.put(player.getUniqueId(), new NPlayer(player)) ;
    }

    /**
     * Remove a player from the cache when the player goes offline
     * */
    public void removePlayer(UUID uuid) {
        playersCache.remove(uuid);
    }

    /**
     * Clear the HashMap from memory
     * */
    public void clearCache() {
        playersCache.clear();
    }
}
