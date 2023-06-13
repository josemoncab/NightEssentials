package dev.josemc.essentials.commands.impl;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.commands.EssentialsCommand;
import revxrsal.commands.annotation.*;
import revxrsal.commands.bukkit.BukkitCommandActor;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.help.CommandHelp;


/**
 * Developer command used to test features
 * */
@Command("test")
public class TestCommand extends EssentialsCommand {

    @DefaultFor("test")
    public void test(BukkitCommandActor sender) {
        sender.reply(parse("<yellow>data: Pruebas sobre los datos del jugador</yellow>"));
    }

    @Subcommand("data")
    public void testPlayerData(BukkitCommandActor actor, String toSave) {
        Essentials.dm().getPlayer(actor.getUniqueId()).set("test", toSave);
        actor.reply("Saved data to the file");
    }

    @Subcommand("cooldown")
    @Cooldown(10)
    public void testCooldown(BukkitCommandActor actor) {
        actor.reply("Solo me usas cada 10 segundo");
    }

    @Subcommand("help")
    public void help(CommandActor actor, CommandHelp<String> helpEntries, @Default("1") int page) {
        for (String entry : helpEntries.paginate(page, 7))
            actor.reply(entry);
    }
}
