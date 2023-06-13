package dev.josemc.essentials.commands;

import dev.josemc.essentials.Essentials;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

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
        Reflections reflections = new Reflections("dev.josemc.essentials.commands.impl", Scanners.SubTypes);

        Set<Class<? extends EssentialsCommand>> classes = reflections.getSubTypesOf(EssentialsCommand.class);

        classes.forEach(c -> {
            try {
                commandHandler.register(c.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
