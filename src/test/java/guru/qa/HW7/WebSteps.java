package guru.qa.HW7;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open main page")
    public void openGitPage() {
        open("https://github.com/");
    }

    @Step("Find Repozitoriy{repo}")
    public void searchSelectedReoi(String repo) {
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Link to the repozitoriy link{repo}")
    public void openSelectedRepo(String repo) {
        $(".repo-list").$(byText(repo)).click();
    }

    @Step("Check the result of the test-Issue tab is visible")
    public void checkResultThatIssueTavIsVisible() {
        $("#issues-tab").shouldBe(Condition.visible);
        attachScreenshot();
    }

    @Attachment(value = "My favorute screenshot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}

