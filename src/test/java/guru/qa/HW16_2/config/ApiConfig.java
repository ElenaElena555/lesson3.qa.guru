package guru.qa.HW16_2.config;

import org.aeonbits.owner.Config;

public interface ApiConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/")
    String baseUrl();
}
