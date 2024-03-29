package guru.qa.HW12;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.HW6.pages.RegistrationFormPage;
import guru.qa.Helper.Attaches;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String name = "Elena";

    String lastName = "Sharapova";
    String email = "lenasyhanova@yandex.ru";
    String phoneNumber = "8921423256";
    String address = "Montenegro, Budva";
    String month = "November";
    String year = "1992";
    String state = "NCR";
    String city = "Delhi";
    String day = "24";
    String subject = "Maths";
    String image = "1.jpg";
    String gender = "Female";
    String hobby = "Reading";


    // [id=  #
    // [class=
    @BeforeAll

    static void setUp() {
        Configuration.holdBrowserOpen = true;
        //Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1420x1070";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
@AfterEach
void addAttachments(){
        Attaches.screenshotAs("last screenshot");
        Attaches.pageSource();
        Attaches.browserConsoleLogs();
}


    @Test
    @DisplayName("Registration test")
    void fillFormTest() {


        registrationFormPage.openPage()
                .setName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .setGender(gender)
                .addImage(image)
                .setSubject(subject)
                .setHobby()
                .setState(state)
                .setCity(city)
                .setBirthday(day, month, year)
                .submitRegistrationForm();



        //assert
        registrationFormPage.checkResultOfRegistration("Student Name", name + " " + lastName)
                .checkResultOfRegistration("Student Email", email)
                .checkResultOfRegistration("Gender", gender)
                .checkResultOfRegistration("Mobile", phoneNumber)
                .checkResultOfRegistration("Date of Birth", day + " " + month + "," + year)
                .checkResultOfRegistration("Subjects", subject)
                .checkResultOfRegistration("Hobbies", hobby)
                .checkResultOfRegistration("Picture", image)
                .checkResultOfRegistration("Address", address)
                .checkResultOfRegistration("State and City", state + " " + city);

    }

}
