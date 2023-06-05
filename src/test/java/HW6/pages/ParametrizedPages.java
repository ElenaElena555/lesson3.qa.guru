package HW6.pages;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedPages {
   //Locators


    //Actions:
    public ParametrizedPages openAmazonPage(){
        open("https://www.amazon.com/");
        return this;
    }
    public ParametrizedPages setSearchData(String testData){
        $("#twotabsearchtextbox").setValue(testData);
        return this;
    }

    public ParametrizedPages clickSearchBtn(){
        $("#nav-search-submit-button").click();
        return  this;
    }
    public ParametrizedPages checkResultsAmazon(String testData){
        $(".sg-col-inner").shouldHave(text(testData));
        return  this;
    }
    public ParametrizedPages checkMenuResultsAmazon(String  expectedResult) {
        $("#departments").equals(text(expectedResult));
        return this;
    }
    public  ParametrizedPages clickOnLeftMenu(){
        $("#nav-search-dropdown-card").click();
        return this;
    }
    public ParametrizedPages checkLeftMenu(String expectedResult){
        $("#nav-search-dropdown-card").shouldHave(text(expectedResult));
        return this;
    }
}
