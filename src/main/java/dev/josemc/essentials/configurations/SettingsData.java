package dev.josemc.essentials.configurations;

import dev.josemc.essentials.configurations.category.ConfigCategory;
import dev.josemc.essentials.configurations.category.settings.GeneralCategory;
import dev.josemc.essentials.configurations.category.settings.WarpsCategory;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class SettingsData extends ConfigCategory {

    @Setting("general")
    @Comment("General settings of the plugin")
    public GeneralCategory general = new GeneralCategory();

    @Setting("warps")
    @Comment("Configs for warp system")
    public WarpsCategory warps = new WarpsCategory();
}
