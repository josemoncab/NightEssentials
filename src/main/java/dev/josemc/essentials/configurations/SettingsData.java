package dev.josemc.essentials.configurations;

import dev.josemc.essentials.configurations.category.ConfigCategory;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class SettingsData extends ConfigCategory {

    @Setting("General")
    @Comment("General settings of the plugin")
    public General general = new General();

    @ConfigSerializable
    static class General {

        @Setting("Debug")
        @Comment("Enable/Disable de debug mode")
        public boolean debug = false;

        @Setting("Language")
        @Comment("Available languages (en, es)")
        public String language = "es";
    }
}
