package HW6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTests {

    @DisplayName("Test#1")
    @Test
    void firstTest(){
        open("https://www.amazon.com/");
        $("#twotabsearchtextbox").setValue("dresses");
        $("#nav-search-submit-button").click();
        $(".a-color-state a-text-bold").shouldHave(text("dresses"));

    }

}
