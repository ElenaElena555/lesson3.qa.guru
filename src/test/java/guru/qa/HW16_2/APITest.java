package guru.qa.HW16_2;

import guru.qa.HW16_2.config.ApiConfig;
import guru.qa.HW16_2.config.TokenConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class APITest {
    @Test
    public void apiTest() {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        TokenConfig configToken = ConfigFactory.create(TokenConfig.class, System.getProperties());
        assertThat(config.baseUrl()).isEqualTo("https://demoqa.com/");
        assertThat(configToken.token()).isEqualTo("1234abcd1234abcd");
    }
}
