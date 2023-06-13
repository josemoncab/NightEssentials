package dev.josemc.essentials.files.values;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.utils.AdventureUtils;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * All command related messages, errors, descriptions and usages
 * */
public enum Commands {
    MISSING_ARGUMENTS("Errors.Missing-Arguments"),
    INVALID_ENUM("Errors.Invalid-Enum"),
    INVALID_NUMBER("Errors.Invalid-Number"),
    INVALID_UUID("Errors.Invalid-UUID"),
    INVALID_URL("Errors.Invalid-URL"),
    INVALID_BOOLEAN("Errors.Invalid-Boolean"),
    INVALID_STRING("Errors.Invalid-String"),
    INVALID_COMMAND("Errors.Invalid-Command"),
    INVALID_SUBCOMMAND("Errors.Invalid-Subcommand"),
    INVALID_HELP_PAGE("Errors.Invalid-Help-Page"),
    INVALID_PLAYER("Errors.Invalid-Player"),
    INVALID_WORLD("Errors.Invalid-World"),
    INVALID_SELECTOR("Errors.Invalid-Selector"),
    ONLY_ONE_PLAYER("Errors.Only-One-Player"),
    MUST_BE_PLAYER("Errors.Must-Be-Player"),
    MUST_BE_CONSOLE("Errors.Must-Be-Console"),
    NO_PERMISSION("Errors.No-Permission"),
    NON_PLAYERS_NOT_ALLOWED("Errors.Non-Players-Not-Allowed"),
    NO_SUBCOMMAND_SPECIFIED("Errors.No-Subcommand-Specified"),
    NUMBER_NOT_IN_RANGE("Errors.Number-Not-In-Range"),
    ERROR("Errors.Error"),
    TOO_MANY_ARGUMENTS("Errors.Too-Many-Arguments"),
    ON_COOLDOWN("Errors.On-Cooldown"),


    ;

    final String path;

    Commands(String path) {
        this.path = path;
    }

    public ComponentLike send(TagResolver ...resolver) {
        return AdventureUtils.parse(Essentials.cm().getCommands().getString(path), resolver);
    }
}
