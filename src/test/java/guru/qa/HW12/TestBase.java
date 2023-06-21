package guru.qa.HW12;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.Helper.Attaches;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
//    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //     Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
 //       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        Configuration.baseUrl = "https://astrio.ru/";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browsersize");
      //  Configuration.remote = "https://" + configs.selenoidLogin() + ":" + configs.selenoidPass() + "@" + System.getProperty("selenoid_server");
    }

    @AfterEach
    void addAttachments() {
        Attaches.screenshotAs("Last screenshot");
        Attaches.pageSource();
        Attaches.browserConsoleLogs();
        Attaches.addVideo();
        closeWebDriver();
    }
}
