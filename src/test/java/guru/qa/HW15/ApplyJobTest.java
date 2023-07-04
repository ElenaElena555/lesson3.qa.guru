package guru.qa.HW15;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Tag("JobTests")
public class ApplyJobTest extends TestBaseHW15{
    VacancyDetailsPage vacancyDetailsPage = new VacancyDetailsPage();

    @Test
    @Owner("elenash")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    @DisplayName("Vacancy parameters are exists in Description")
    void checkThatParametersExistsInDescription() {
        String typeOfWork = "Полная занятость, удаленная работа";
        String workExperience = "Требуемый опыт работы: 1–3 года";
        vacancyDetailsPage.openVacancy()
                // .checkTypeOfWorkImVacancyDescription(typeOfWork)
                .checkTypeOfWorkImVacancyDescription(workExperience);
    }


    @Test
    @Owner("elenash")
    @Severity(SeverityLevel.MINOR)
    @Feature("Job details")
    @Story("Jobs")
    @DisplayName("Status of the vacancy")
    void checkAddressVacancy() {
        String address = "Вакансия в архиве";
        vacancyDetailsPage.openVacancy()
                .checkStatusOfVacancy(address);
    }

    @ValueSource(strings = {
            "elenasharapova@@gmail.com", //invalid data to show Failed status in Report
            "elenasharapova3@" //invalid data to show Failed status in Report
    })
    @ParameterizedTest(name = "Check that valid Email {0} is Applied")
    @Owner("elenash")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    void checkValidEmailIsApplied(String testData) {
        vacancyDetailsPage.openVacancy()
                .enterEmail(testData)
                .checkEmailValidation();
    }

    @ValueSource(strings = {
            "elenasharapova@@gmail.com", //invalid data to show Failed status in Report
            "elenasharapova3@" //invalid data to show Failed status in Report
    })

    @ParameterizedTest(name = "Check that Error is displayed when invalid Email {0} is entered")
    @Owner("yuliyabyshko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Job details")
    @Story("Jobs")
    @Disabled
        //disabled to show Skipped status in Report
    void checkErrorDisplayedWhenInvalidEmailEntered(String testData) {
        vacancyDetailsPage.openVacancy()
                .enterEmail(testData)
                .checkWrongEmailValidation();
    }
}
