package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class SimpleClass {
    @BeforeAll
    static void initDB() {
        System.out.println();
    }

    ;

    @BeforeEach
    void openGooglePage() {
        open("https://www.google.com/");
    }

    @AfterEach
    void closeGooglePage() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    void assertTest() {
        open();
        Assertions.assertTrue(2 > 3);

    }
}
