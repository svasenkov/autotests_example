package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.Environment.isHeadless;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        Configuration.headless = Boolean.parseBoolean(isHeadless);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    public void closeBrowser(){
        closeWebDriver();
    }
}
