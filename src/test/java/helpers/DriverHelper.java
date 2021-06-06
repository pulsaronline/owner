package helpers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import config.WebDriverConfig;

public class DriverHelper {
    private static final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    private static WebDriverConfig getDriverConfig(){
        return ConfigFactory.newInstance().create(WebDriverConfig.class, System.getProperties());
    }

    public static boolean isRemote(){
        return config.isRemote();
    }

    public static void configureDriver(String baseUrl){
        Configuration.startMaximized = true;
        Configuration.baseUrl = baseUrl;
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserVersion = config.webdriverBrowserVersion();
        Configuration.timeout = 4000;

        if (isRemote()) {
            Configuration.remote = config.getRemoteURL().toString();
        }
    }
}
