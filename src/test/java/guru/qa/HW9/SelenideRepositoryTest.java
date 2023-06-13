package guru.qa.HW9;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest {
    @Test
    void shouldFindSelenideAsfirstreppository(){
        //open git.com page
        open("https://github.com/");
        //find selenide and click search button
        $(".header-search-input").setValue("selenide").pressEnter();
        //click on the first founded link
        $$("ul.repo-list li").first().$("a").click(); //need to use two $ for the list element or you can make $$("ul.repo-list li a").click();
        //check: the title has selenide/selenide
        $("h1").shouldHave(text("selenide/selenide"));
    }
}
