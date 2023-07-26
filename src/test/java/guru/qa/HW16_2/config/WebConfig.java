package guru.qa.HW16_2.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:HW16/${launch}.properties"
})
public interface WebConfig extends Config {
    @Key("browser.name")
    String browserName();

    @Key("browser.version")
    String browserVersion();

    @Key("launch.type")
    String launchType();
}
