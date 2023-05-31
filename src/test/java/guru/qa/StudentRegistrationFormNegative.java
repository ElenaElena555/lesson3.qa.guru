package guru.qa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormNegative {
   String empty = " ";
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void checkNegativeOption() {
        open("https://demoqa.com/automation-practice-form");
        zoom(0.75);
        $("#firstName").setValue(empty);
        $("#lastName").setValue(empty);
        $("#userEmail").setValue(empty);
        $("#userNumber").setValue(empty);
        $("#dateOfBirthInput").clear();
        $("#submit").click();


    }

}
