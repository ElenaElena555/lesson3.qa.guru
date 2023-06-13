package guru.qa.HW9;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideHW9Test {
    @DisplayName("Test for GitHub")
    @Test
    void checkSoftAssertionsPageForGitHub() {
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
     //  $$("#wiki-pages-box li").find(text("SoftAssertions")).click();

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$(".markdown-body ul li").find(text("JUnit5")).shouldBe(visible);
  //      $$(".markdown-body h4").find(Condition.text("JUnit5")).shouldBe(Condition.visible);
    }

}
