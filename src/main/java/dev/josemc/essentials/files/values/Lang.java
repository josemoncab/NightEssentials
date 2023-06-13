package dev.josemc.essentials.files.values;

import dev.josemc.essentials.Essentials;
import dev.josemc.essentials.utils.AdventureUtils;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public enum Lang {
    PREFIX("Prefix"),

    ;

    final String path;

    Lang(String path) {
        this.path = path;
    }

    public String get() {
        return Essentials.cm().getLang().getString(path);
    }

    public ComponentLike send(TagResolver...resolver) {
        return AdventureUtils.parse(Essentials.cm().getLang().getString(path), resolver);
    }
}
