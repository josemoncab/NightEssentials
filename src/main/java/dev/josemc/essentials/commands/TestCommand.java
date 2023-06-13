package dev.josemc.essentials.commands;

import dev.josemc.essentials.Essentials;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.command.CommandActor;

public class TestCommand {

    @Command("test data")
    public void testPlayerData(CommandActor actor, String toSave) {
        Essentials.dm().getPlayer(actor.getUniqueId()).set("test", toSave);
        actor.reply("Saved data to the file");
    }
}
