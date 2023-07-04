package guru.qa.HW15;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VacancyDetailsPage {
    //locators


    SelenideElement vacancyDetailsPageTitle = $(by("data-qa", "vacancy-title")),
            vacancyworkExperience = $(".vacancy-description-list-item"),
            vacancyWorkType = $(".vacancy-description-list-item"),
            vacancyStatus = $(".vacancy-section"),
            clickLoginButton = $(".ahm3WtA___link-to-settings"),
            enterEmail = $(by("data-qa","account-signup-email")),
            clickSubmitButton = $(by("data-qa", "account-signup-submit")),
            enterCode = $(by("data-qa","otp-code-form")),

            validationMessage=$(".field-error-login_EMPTY");

    //actions
    @Step("Open Vacancy Details Page")
    public VacancyDetailsPage openVacancy() {
        open("https://hh.ru/vacancy/55354866?query=QA%20automation%20engineer&from=vacancy_search_catalog&hhtmFrom=vacancy_search_catalog");
        vacancyDetailsPageTitle.shouldHave(text("QA"));
        return this;
    }

    @Step("Check that workExperience exists in vacancy description")
    public VacancyDetailsPage checkVacancyDescription(String workExperience) {
        vacancyworkExperience.shouldHave(text(workExperience));
        return this;
    }

    @Step("Check that type of work exists in vacancy description")
    public VacancyDetailsPage checkTypeOfWorkImVacancyDescription(String typeOfWork) {
        vacancyWorkType.shouldHave(text(typeOfWork));
        return this;
    }

    @Step("Check that status of the vacancy is archive")
    public VacancyDetailsPage checkStatusOfVacancy(String address) {
        vacancyStatus.shouldHave(text(address));
        return this;
    }

    @Step("Enter email")
    public VacancyDetailsPage enterEmail(String email) {
        clickLoginButton.click();
        enterEmail.setValue(email);
        clickSubmitButton.click();
        return this;
    }

    @Step("check email validation with valis values")
    public VacancyDetailsPage checkEmailValidation(){
        enterCode.shouldBe(visible);
        return this;
    }

    @Step("check email validation with invalid values")
    public VacancyDetailsPage checkWrongEmailValidation(){
        validationMessage.shouldBe(visible);
        return this;
    }
}
