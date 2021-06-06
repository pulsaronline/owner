package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebDriverTest {

    @Test
    public void testWebDriver(){
        open("https://playrix.com/");
        $(".main-menu__link").shouldHave(text("Игры"));
    }
}
