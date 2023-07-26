package guru.qa.HW16Owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    //зачитываем данные из командной строки
    @Key("browser")
    //обрабатываем дефолтное значение
    @DefaultValue("CHROME")
    //конвертируем в возвращаемый тип
    Browser getBrowser();

    @Key("remoteUrl")
    @DefaultValue("https://localhost:4444/wd/hub")
    URL getRemoteUrl();
}
