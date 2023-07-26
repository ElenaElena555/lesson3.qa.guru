package guru.qa.HW16_2;

import guru.qa.HW16_2.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@Tag("webTests")
public class WebTest {
    @Test
    public void webTest(){
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.browserName()).isEqualTo("CHROME");
        assertThat(config.browserVersion()).isEqualTo("100");
        assertThat(config.launchType()).isEqualTo(""); //for gradle clean test -Dlaunch=local
    }
}
