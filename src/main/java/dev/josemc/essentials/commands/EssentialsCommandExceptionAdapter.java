/*
 * This file is part of lamp, licensed under the MIT License.
 *
 *  Copyright (c) Revxrsal <reflxction.github@gmail.com>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package dev.josemc.essentials.commands;

import dev.josemc.essentials.files.values.Commands;
import dev.josemc.essentials.utils.AdventureUtils;
import org.jetbrains.annotations.NotNull;
import revxrsal.commands.bukkit.BukkitCommandActor;
import revxrsal.commands.bukkit.exception.*;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.command.ExecutableCommand;
import revxrsal.commands.exception.*;

/**
 * Exception handler to errors occur when a command runs
 * Changed all messages to support Adventure Components and custom messages keys
 * */
public class EssentialsCommandExceptionAdapter extends BukkitExceptionAdapter {

    public static final EssentialsCommandExceptionAdapter INSTANCE = new EssentialsCommandExceptionAdapter();

    public void missingArgument(@NotNull BukkitCommandActor actor, @NotNull MissingArgumentException exception) {
        actor.reply(Commands.MISSING_ARGUMENTS.send(AdventureUtils.tagResolver("argument", exception.getCommand().getName())));
    }

    public void invalidEnumValue(@NotNull BukkitCommandActor actor, @NotNull EnumNotFoundException exception) {
        actor.reply(Commands.INVALID_ENUM.send(
                AdventureUtils.tagResolver("parameter", exception.getParameter().getName()),
                AdventureUtils.tagResolver("input", exception.getInput()))
        );
    }

    public void invalidNumber(@NotNull BukkitCommandActor actor, @NotNull InvalidNumberException exception) {
        actor.reply(Commands.INVALID_NUMBER.send(
                AdventureUtils.tagResolver("input", exception.getInput()))
        );
    }

    public void invalidUUID(@NotNull BukkitCommandActor actor, @NotNull InvalidUUIDException exception) {
        actor.reply(Commands.INVALID_UUID.send(
                AdventureUtils.tagResolver("input", exception.getInput()))
        );
    }

    public void invalidURL(@NotNull BukkitCommandActor actor, @NotNull InvalidURLException exception) {
        actor.reply(Commands.INVALID_URL.send(
                AdventureUtils.tagResolver("input", exception.getInput()))
        );
    }

    public void invalidBoolean(@NotNull BukkitCommandActor actor, @NotNull InvalidBooleanException exception) {
        actor.reply(Commands.INVALID_BOOLEAN.send(
                AdventureUtils.tagResolver("boolean", exception.getInput()))
        );
    }

    public void noPermission(@NotNull BukkitCommandActor actor, @NotNull NoPermissionException exception) {
        actor.reply(Commands.NO_PERMISSION.send(
                AdventureUtils.tagResolver("permission", exception.getPermission().toString()))
        );
    }

    public void argumentParse(@NotNull BukkitCommandActor actor, @NotNull ArgumentParseException exception) {
        actor.reply(Commands.INVALID_STRING.send(
                AdventureUtils.tagResolver("string", exception.getSourceString()),
                AdventureUtils.tagResolver("position", exception.getAnnotatedPosition()))
        );
    }

    public void commandInvocation(@NotNull BukkitCommandActor actor, @NotNull CommandInvocationException exception) {
        actor.reply(Commands.ERROR.send());
        exception.getCause().printStackTrace();
    }

    public void tooManyArguments(@NotNull BukkitCommandActor actor, @NotNull TooManyArgumentsException exception) {
        ExecutableCommand command = exception.getCommand();
        String usage = (command.getPath().toRealString() + " " + command.getUsage()).trim();
        actor.reply(Commands.TOO_MANY_ARGUMENTS.send(
                AdventureUtils.tagResolver("usage", usage)
        ));
    }

    public void invalidCommand(@NotNull BukkitCommandActor actor, @NotNull InvalidCommandException exception) {
        actor.reply(Commands.INVALID_COMMAND.send(
                AdventureUtils.tagResolver("input", exception.getInput())
        ));
    }

    public void invalidSubcommand(@NotNull BukkitCommandActor actor, @NotNull InvalidSubcommandException exception) {
        actor.reply(Commands.INVALID_SUBCOMMAND.send(
                AdventureUtils.tagResolver("input", exception.getInput())
        ));
    }

    public void noSubcommandSpecified(@NotNull BukkitCommandActor actor, @NotNull NoSubcommandSpecifiedException exception) {
        actor.reply(Commands.NO_SUBCOMMAND_SPECIFIED.send());
    }

    public void cooldown(@NotNull BukkitCommandActor actor, @NotNull CooldownException exception) {
        actor.reply(Commands.ON_COOLDOWN.send(
                AdventureUtils.tagResolver("time-left", DefaultExceptionHandler.formatTimeFancy(exception.getTimeLeftMillis()))
        ));
    }

    public void invalidHelpPage(@NotNull BukkitCommandActor actor, @NotNull InvalidHelpPageException exception) {
        actor.reply(Commands.INVALID_HELP_PAGE.send(
                AdventureUtils.tagResolver("page", Integer.toString(exception.getPage())),
                AdventureUtils.tagResolver("page-count", Integer.toString(exception.getPageCount()))
        ));
    }

    public void sendableException(@NotNull CommandActor actor, @NotNull SendableException exception) {
        exception.sendTo(actor);
    }

    public void numberNotInRange(@NotNull BukkitCommandActor actor, @NotNull NumberNotInRangeException exception) {
        actor.reply(Commands.NUMBER_NOT_IN_RANGE.send(
                AdventureUtils.tagResolver("name", exception.getParameter().getName()),
                AdventureUtils.tagResolver("minimum", DefaultExceptionHandler.FORMAT.format(exception.getMinimum())),
                AdventureUtils.tagResolver("maximum", DefaultExceptionHandler.FORMAT.format(exception.getMaximum())),
                AdventureUtils.tagResolver("input", DefaultExceptionHandler.FORMAT.format(exception.getInput())
        )));
    }
    public void senderNotPlayer(@NotNull BukkitCommandActor actor, @NotNull SenderNotPlayerException exception) {
        actor.reply(Commands.MUST_BE_PLAYER.send());
    }

    public void senderNotConsole(@NotNull BukkitCommandActor actor, @NotNull SenderNotConsoleException exception) {
        actor.reply(Commands.MUST_BE_CONSOLE.send());
    }

    public void invalidPlayer(@NotNull BukkitCommandActor actor, @NotNull InvalidPlayerException exception) {
        actor.reply(Commands.INVALID_PLAYER.send(
                AdventureUtils.tagResolver("input", exception.getInput())
        ));
    }

    public void invalidWorld(@NotNull BukkitCommandActor actor, @NotNull InvalidWorldException exception) {
        actor.reply(Commands.INVALID_WORLD.send(
                AdventureUtils.tagResolver("input", exception.getInput())
        ));
    }

    public void malformedEntitySelector(@NotNull BukkitCommandActor actor, @NotNull MalformedEntitySelectorException exception) {
        actor.reply(Commands.INVALID_SELECTOR.send(
                AdventureUtils.tagResolver("input", exception.getInput())
        ));
    }

    public void moreThanOnePlayer(@NotNull BukkitCommandActor actor, @NotNull MoreThanOnePlayerException exception) {
        actor.reply(Commands.ONLY_ONE_PLAYER.send(
                AdventureUtils.tagResolver("input", exception.getInput())
        ));
    }

    public void nonPlayerEntities(@NotNull BukkitCommandActor actor, @NotNull NonPlayerEntitiesException exception) {
        actor.reply(Commands.NON_PLAYERS_NOT_ALLOWED.send());
    }

}
