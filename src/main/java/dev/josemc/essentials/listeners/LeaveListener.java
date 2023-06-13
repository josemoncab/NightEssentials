package dev.josemc.essentials.listeners;

import dev.josemc.essentials.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Class that manages all events related to the player leave
 * */

public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Essentials.dm().removePlayer(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onLeave(PlayerKickEvent event) {
        Essentials.dm().removePlayer(event.getPlayer().getUniqueId());
    }
}
