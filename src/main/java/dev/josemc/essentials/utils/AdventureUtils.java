package dev.josemc.essentials.utils;

import dev.josemc.essentials.files.values.Lang;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import java.util.ArrayList;
import java.util.List;

public class AdventureUtils {

    public static final TagResolver essentialsTagResolver = TagResolver.resolver(TagResolver.standard());
    public static final MiniMessage MINI_MESSAGE = MiniMessage.builder().tags(essentialsTagResolver).build();

    public static ComponentLike parse(String message, TagResolver ...resolver) {
        ArrayList<TagResolver> tagResolvers = new ArrayList<>(List.of(resolver));
        tagResolvers.add(AdventureUtils.tagResolver("prefix", Lang.PREFIX.get()));
        return MINI_MESSAGE.deserialize(message, TagResolver.resolver(tagResolvers));
    }

    public static TagResolver tagResolver(String string, String tag) {
        return TagResolver.resolver(string, Tag.selfClosingInserting(AdventureUtils.MINI_MESSAGE.deserialize(tag)));
    }
}
