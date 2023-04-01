package dev.josemc.essentials.configurations.category.settings;

import dev.josemc.essentials.configurations.category.ConfigCategory;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class WarpsCategory extends ConfigCategory {

    @Setting("test")
    public int test = 2;
}
