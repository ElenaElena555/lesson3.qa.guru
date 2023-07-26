package guru.qa.HW16Owner.config;

import io.qameta.allure.Severity;
import org.aeonbits.owner.Config;

import java.util.List;


public interface FruitsConfig extends Config {
    @Key("array")
    String[] getFruitsArray();

    @Key("list")
    List<String> getFruitsList();
    @Key("default")
    @DefaultValue("apple, banana")
    String[] getArrayDefault();

    @Key("separator")
   @Separator(";")
    String[] getArraySeparator();


}
