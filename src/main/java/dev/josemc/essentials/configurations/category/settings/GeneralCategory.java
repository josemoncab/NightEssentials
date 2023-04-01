package dev.josemc.essentials.configurations.category.settings;

import dev.josemc.essentials.configurations.category.ConfigCategory;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class GeneralCategory extends ConfigCategory {

    @Setting("language")
    @Comment("Available languages (es, en)")
    public String language = "es";
}
