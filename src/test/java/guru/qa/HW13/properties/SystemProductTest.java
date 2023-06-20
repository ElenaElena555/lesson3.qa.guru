package guru.qa.HW13.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

@Tag("systemProperties")
public class SystemProductTest {

    @Test
    void someTest1() {
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }

    @Test
    void someTest2() {
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser");
        System.out.println(browser);// safari
    }

    @Test
    void someTest3() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);// opera
    }

    @Test
    void someTest4() {
        System.setProperty("browser", "safari");
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);// safari
    }
    @Test
    void someTest5() {
        String browser = System.getProperty("browser", "opera");
        String version = System.getProperty("browser", "100");
       String browserSize = System.getProperty("browser", "1920x1080");
        System.out.println(browser);// safari
        System.out.println(version);
        System.out.println(browserSize);
    }
    @Test
    void someTest6() {
        System.out.println("I want to say:" + System.getProperty("hello"));
    }
}
