package guru.qa.HW6;

import guru.qa.domain.MenuItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import guru.qa.HW6.pages.ParametrizedPages;

import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTests2 {
    ParametrizedPages parametrizedPages = new ParametrizedPages();

    @ValueSource(strings = {
            "dresses",
            "jeans"
    }) //DATA Provider for parametrized tests

    @ParameterizedTest(name = "Searching {0} on Amazon by Search option")
    void firstTestForSearching(String testData) {
        //Precondition
        parametrizedPages.openAmazonPage()
                //STR:
                .setSearchData(testData)
                .clickSearchBtn()
                //ER:
                .setSearchData(testData);

    }

    @CsvSource(value = {"dresses| results for \"dresses\"", "jeans| results for \"jeans\""},
            delimiter = '|')
    @ParameterizedTest(name = "Searching {0} on Amazon by Search option, expect the result {1}")
    void complexTestForSearching(String testData, String expectedResult) {
        //Precondition
        parametrizedPages.openAmazonPage()
                //STR:
                .setSearchData(testData)
                .clickSearchBtn()
                //ER:
                .checkResultsAmazon(expectedResult);

    }

    //The standard shell for writing a date provider
    static Stream<Arguments> methodSourceExampleTest() {

        return
                Stream.of(
                        Arguments.of("jeans", List.of("Amazon Essentials", "Levi's")),
                        Arguments.of("dresses", List.of("Amazon Essentials", "Dokotoo")));
    }

    @MethodSource("methodSourceExampleTest")
    @ParameterizedTest
    void methodSourceExampleTest(String testData, List<String> expectedResult) {
        //Precondition
        parametrizedPages.openAmazonPage()
                //STR
                .setSearchData(testData)
                .clickSearchBtn()
                //ER
                .checkMenuResultsAmazon(expectedResult.toString());


    }

    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Searching {0} on Amazon by Search option")
    void SearchingMenuItemsTest(MenuItem testData) {
        //Precondition
        parametrizedPages.openAmazonPage()
                //STR:
                .setSearchData("jeans")
                .clickSearchBtn()
                .clickOnLeftMenu()
                //ER:
                .checkLeftMenu(testData.engName);

    }
}



