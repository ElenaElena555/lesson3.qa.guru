package guru.qa.HW16Owner;

import guru.qa.HW16Owner.config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private WebDriver driver = new WebDriverProvider().get();

@Tag("HW16")
    @Test
    public void testGitHubTitle() {
//        //настройка chrome driver, если все хорошо сконфигурировано, то она не нужна
//        WebDriverManager.chromedriver().setup();
//
//        //онфигурация запуска: browser=chrome. base url = https://github.com
//        WebDriver driver = new ChromeDriver();
//
//        //код выполнения теста
//        driver.get("https://www.github.com");
        String title = driver.getTitle();
        assertEquals(title, "Don't know about title");

    }
    @AfterEach
    public void stopDriver(){
        driver.quit();
    }
}
