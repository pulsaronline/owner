import config.FruitsConfig;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitsTest {

    @Test
    public void fruitsTest(){
        System.setProperty("fruits.items", "banana, apple, orange");
        FruitsConfig config = ConfigFactory
                .create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruits())
                .contains("banana", "apple", "orange");
    }

    @Test
    public void fruitsSeparator(){
        System.setProperty("fruits.items", "banana;apple;orange");
        FruitsConfig config = ConfigFactory
                .create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsSeparator())
                .contains("banana", "apple", "orange");
    }

    @Test
    public void fruitsDefaultValue(){
        FruitsConfig config = ConfigFactory
                .create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsDefaultValue())
                .contains("banana", "apple", "orange");
    }
}
