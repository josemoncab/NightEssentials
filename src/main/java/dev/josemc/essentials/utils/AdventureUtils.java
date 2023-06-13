package dev.josemc.essentials.utils;

import dev.josemc.essentials.files.values.Lang;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with methods for simplify working with MiniMessage
 * */
public class AdventureUtils {

    /**
     * Utility class
     * */
    private AdventureUtils() {
        throw new UnsupportedOperationException("Utility Class");
    }

    /**
     * MiniMessage instance used in the plugin
     * */
    public static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    /**
     * Parse a string message into Components with custom tag resolvers
     *
     * @param message String to convert
     * @param resolvers List of {@link TagResolver} used by custom variables
     *
     * @return Component ready to get send by Adventure
     * */
    public static ComponentLike parse(String message, TagResolver ...resolvers) {
        ArrayList<TagResolver> tagResolvers = new ArrayList<>(List.of(resolvers));
        tagResolvers.add(TagResolver.standard());
        tagResolvers.add(AdventureUtils.tagResolver("prefix", Lang.PREFIX.get()));
        return MINI_MESSAGE.deserialize(message, TagResolver.resolver(tagResolvers));
    }

    /**
     * Create a self-closing {@link TagResolver}
     *
     * @param tag String used to represent the tag "<example/>"
     * @param msg String used to replace the value
     *
     * @return {@link TagResolver}
     * */
    public static TagResolver tagResolver(String tag, String msg) {
        return TagResolver.resolver(tag, Tag.selfClosingInserting(AdventureUtils.MINI_MESSAGE.deserialize(msg)));
    }
}
