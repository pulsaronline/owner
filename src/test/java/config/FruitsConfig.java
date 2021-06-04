package config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {
    @Key("fruits.items")
    List<String> getFruits();

    @Separator(";")
    @Key("fruits.items")
    List<String> getFruitsSeparator();

    @Separator("_")
    @Key("fruits.items")
    @DefaultValue("banana_apple_orange")
    List<String> getFruitsDefaultValue();
}
