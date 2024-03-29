package guru.qa.HW9;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContributorTest {

    @Test
    void solncevShouldBeFirstContributor(){
        // open repository page
        open("https://github.com/selenide/selenide");
        // bring mouse over the first avatar on contributors tab
        $(".Layout-sidebar").$(byText("Contributors")).ancestor("div").$$("ul li").first().hover();

        // check: popup is showing Andres Solntsev
        $$(".Popover-message").findBy(visible).shouldHave(text("asolntsev"));

    }
}
