package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.HW12.TestBase;
import guru.qa.Helper.Attaches;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


@Tag("demoqa")

public class StudentRegFormTest extends TestBase {
    String name = "Elena";
    String lastName = "Sharapova";
    String email = "lenasyhanova@yandex.ru";
    String phoneNumber = "8921423256";
    String address = "Montenegro, Budva";
    String month = "November";
    String year = "1992";
    String state = "NCR";
    String city = "Delhi";
    String date = "24";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        //     Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1420x1070";

    }

    @Test
    @DisplayName("registration Form Test2.0")
    void fillFormTest() {
        //arrange
        open("https://demoqa.com/automation-practice-form");
        zoom(0.75);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //act
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[id=firstName]").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-2").parent().click();
        //    $(byText("Female")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(byText(date)).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        // $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue(address);
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
        // [id=  #
        // [class=  .


        //assert
        $(".modal-body").shouldHave(
                text(name + " " + lastName),
                text(email),
                text("female"),
                text(phoneNumber),
                text(date + " " + month + "," + year),
                text("Maths"),
                text("Reading"),
                text("1.jpg"),
                text(address),
                text(state + " " + city));
    }
    // $(".table-responsive").$(byText("Student Name").parents().shouldHave(text("elena Sharapova");
}
