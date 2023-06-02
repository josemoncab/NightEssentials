package dev.josemc.essentials.listeners;

import dev.josemc.essentials.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Class that manages all events related to the player join
 * */

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Essentials.dm().loadPlayer(event.getPlayer());
    }
}
