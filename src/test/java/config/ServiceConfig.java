package config;

import org.aeonbits.owner.Config;

public interface ServiceConfig extends Config {
    //@DefaultValue("https://tests/github.com")
    @DefaultValue("https://github.com")
    @Key("service.baseUrl")
    String getBaseUrl();

    @DefaultValue("pulsaronline")
    @Key("service.username")
    String getUsername();

    @DefaultValue("Newage36")
    @Key("service.password")
    String getPassword();

}
