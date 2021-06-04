import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebDriverTest {
    private WebDriver driver;

    @BeforeEach
    public void initDriver(){
        System.setProperty("webdriver.remote", "true");
        System.setProperty("webdriver.browser", "chrome");
        //System.setProperty("webdriver.browser", "firefox");
        //System.setProperty("webdriver.browser", "safari");
        System.setProperty("webdriver.url", "https://user1:1234@selenoid.autotests.cloud/wd/hub/");

        WebDriverConfig config = ConfigFactory
                .create(WebDriverConfig.class, System.getProperties());
        initWebDriver(config);
}

    @Test
    public void testWebDriver(){

        driver.get("https://github.com");
        assertThat(driver.getTitle())
                .isEqualTo("GitHub: Where the world builds software · GitHub");
    }

    @AfterEach
    public void stopDriver(){
        driver.quit();
    }

    private void initWebDriver(WebDriverConfig config){
        if(config.isRemote()){
            DesiredCapabilities capabilities;
            switch (config.getBrowser()) {
                case CHROME:{
                    capabilities = DesiredCapabilities.chrome();
                    break;
                }
                case OPERA:{
                    capabilities = DesiredCapabilities.opera();
                    break;
                }
                case FIREFOX:{
                    capabilities = DesiredCapabilities.firefox();
                    break;
                }
                case SAFARI:{
                    capabilities = DesiredCapabilities.safari();
                    break;
                }
                default:{
                    capabilities = DesiredCapabilities.chrome();
                }
            }
            driver = new RemoteWebDriver(config.getURL(), capabilities);
        }
        else {
            driver = new ChromeDriver();
        }
    }
}
