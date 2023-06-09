package guru.qa.HW6.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import guru.qa.HW6.pages.components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    Calendar calendar = new Calendar();
    //locators
    SelenideElement firstName = $("[id=firstName]");

    //actions
    public static void setUpForRegistration() {
        Configuration.holdBrowserOpen = true;
        //     Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1420x1070";

    }

    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        zoom(0.75);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationFormPage setName(String name) {
        $("[id=firstName]").setValue(name);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationFormPage addImage(String image) {
        File file = $("#uploadPicture").uploadFromClasspath(image);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;
    }

    public RegistrationFormPage setCity(String city) {
        $("#stateCity-wrapper").click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationFormPage submitRegistrationForm() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby() {
        $("#hobbies-checkbox-2").parent().click();
        // $(byText("Sports")).click();
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        $("#gender-radio-2").parent().click();
        //    $(byText("Female")).click();
        return this;
    }

    public RegistrationFormPage setBirthday(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setData(day, month, year);
        return this;
    }

    public RegistrationFormPage checkResultOfRegistration(String key, String result) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(result));
        return this;
    }

}
