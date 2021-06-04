import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebDriverConfigTest {

    @Test
    public void testUrl(){
        System.setProperty("webdriver.url", "https://user1:1234@selenoid.autotests.cloud/wd/hub/");
        WebDriverConfig config = ConfigFactory
            .create(WebDriverConfig.class, System.getProperties());
        assertThat(config.getURL().toString()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}
