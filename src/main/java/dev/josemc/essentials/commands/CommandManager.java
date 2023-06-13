package dev.josemc.essentials.commands;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.commands.impl.TestCommand;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class CommandManager {
    private final BukkitCommandHandler commandHandler;

    public CommandManager() {
        commandHandler = BukkitCommandHandler.create(Essentials.get());
        commandHandler.enableAdventure(BukkitAudiences.create(Essentials.get()));
        commandHandler.setExceptionHandler(EssentialsCommandExceptionAdapter.INSTANCE);
        registerCommands();
        commandHandler.registerBrigadier();
    }

    private void registerCommands() {
        // TODO: Use reflections
        commandHandler.register(new TestCommand());
    }
}
