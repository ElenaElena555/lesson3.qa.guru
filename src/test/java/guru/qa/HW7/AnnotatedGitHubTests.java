package guru.qa.HW7;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AnnotatedGitHubTests {
    private static final String REPOZITORIY = "/ElenaElena555";

    @Test
    void checkGitHubIssueSearcher() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openGitPage();
        steps.searchSelectedReoi(REPOZITORIY);
        steps.openSelectedRepo("ElenaElena555");
        steps.checkResultThatIssueTavIsVisible();
    }
}
