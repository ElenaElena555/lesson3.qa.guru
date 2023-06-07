package guru.qa.HW7;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

public class LambdaGitHubTests {
    private static final String REPOZITORIY = "/ElenaElena555";

    @Test
    void checkGitHubIssueSearcher() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open maim page", //строка
                () -> {              // функция
                    open("https://github.com/");
                });
        step("Find Repozitoriy" + REPOZITORIY,
                () -> {
                    $(".header-search-input").sendKeys(REPOZITORIY);
                    $(".header-search-input").submit();
                });
        step("Link to the repozitoriy link",
                () -> {
                    $(".repo-list").$(byText("ElenaElena555")).click();
                });
        step("Check the result of the test-Issue tab is visible",
                () -> {
                    $("#issues-tab").shouldBe(Condition.visible);
                    Allure.getLifecycle().addAttachment(
                            "PageSource",
                            "text/html",
                            "html",
                            WebDriverRunner.getWebDriver()
                            .getPageSource().getBytes(StandardCharsets.UTF_8)
                    );

                });


    }
}
