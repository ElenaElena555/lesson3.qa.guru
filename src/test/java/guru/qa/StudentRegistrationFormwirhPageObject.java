package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import guru.qa.HW6.pages.RegistrationFormPage;

@Tag("demoqa")
public class StudentRegistrationFormwirhPageObject {
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


    }



    @Test
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
        ;


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
