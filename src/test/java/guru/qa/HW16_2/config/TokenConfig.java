package guru.qa.HW16_2.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:HW16/token.properties"
})
public interface TokenConfig extends Config{

    @Key("token")
    String token();
}
