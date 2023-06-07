package guru.qa.HW7;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class ParametrizedGitHubTests {
    @Test
    @DisplayName("My favorite Test")
    public void annotatedTest() {
        Allure.parameter("region",  "Montenegro");
        Allure.parameter("city", "Budva");

    }

}
