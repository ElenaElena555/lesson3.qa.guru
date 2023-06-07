package guru.qa.HW7;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTests {

    @Test
    void checkGitHubIssueSearcher() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").sendKeys("/ElenaElena555");
        $(".header-search-input").submit();
        $(".repo-list").$(byText("ElenaElena555")).click();
        $("#issues-tab").shouldBe(Condition.visible);

    }
}
