package config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {
    @DefaultValue("true")
    @Key("webdriver.remote")
    boolean isRemote();

    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    @Key("webdriver.url")
    URL getURL();

    @DefaultValue("CHROME")
    @Key("webdriver.browser")
    BROWSER getBrowser();

    enum BROWSER{
        CHROME,
        FIREFOX,
        OPERA,
        SAFARI
    }
}
