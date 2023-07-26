package guru.qa.HW16Owner;

import guru.qa.HW16Owner.config.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;

public interface TypesConfig extends Config {
    @Key("Integer")
    Integer getInteger();

    @Key("double")
    Double getDouble();

    @Key("boolean")
    Boolean getBoolean();

    @Key("enum")
    Browser getEnum();
    @Key("url")
    URL getURL();

}
