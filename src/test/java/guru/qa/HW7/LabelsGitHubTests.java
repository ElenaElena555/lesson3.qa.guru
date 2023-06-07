package guru.qa.HW7;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;


public class LabelsGitHubTests {
    @Test
    @IssueShow
    @Link(value="Testing", url = "https://github.com/")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("My favorite Test")

    public void annotatedTest() {

    }
    @Test
    public void testCode(){
        Allure.label("owner", "Elena");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.feature("tasks in Repo");
        Allure.story("Show items in Repo");
        Allure.link("testing", "https://github.com/" );
    }
    @Documented
    @Owner("Elena")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Repozitory checking tasks")
    @Story("#1234-4321")
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IssueShow{

    }
}
