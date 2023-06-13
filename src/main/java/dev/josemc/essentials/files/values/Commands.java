package dev.josemc.essentials.files.values;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.utils.AdventureUtils;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * All command related messages, errors, descriptions and usages
 * */
public enum Commands {
    MISSING_ARGUMENTS("Errors."),
    INVALID_ENUM("Errors."),
    INVALID_NUMBER("Errors."),
    INVALID_UUID("Errors."),
    INVALID_URL("Errors."),
    INVALID_BOOLEAN("Errors."),
    INVALID_STRING("Errors."),
    INVALID_COMMAND("Errors."),
    INVALID_SUBCOMMAND("Errors."),
    INVALID_HELP_PAGE("Errors."),
    INVALID_PLAYER("Errors."),
    INVALID_WORLD("Errors."),
    INVALID_SELECTOR("Errors."),
    ONLY_ONE_PLAYER("Errors."),
    MUST_BE_PLAYER("Errors."),
    MUST_BE_CONSOLE("Errors."),
    NO_PERMISSION("Errors."),
    NON_PLAYERS_NOT_ALLOWED("Errors."),
    NO_SUBCOMMAND_SPECIFIED("Errors."),
    NUMBER_NOT_IN_RANGE("Errors."),
    ERROR("Errors."),
    TOO_MANY_ARGUMENTS("Errors."),
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
