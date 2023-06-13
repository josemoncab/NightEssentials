package dev.josemc.essentials.commands;

import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;

public abstract class EssentialsCommand {
    protected MiniMessage miniMessage = MiniMessage.miniMessage();

    protected ComponentLike parse(String txt) {
        return miniMessage.deserialize(txt);
    }
}
