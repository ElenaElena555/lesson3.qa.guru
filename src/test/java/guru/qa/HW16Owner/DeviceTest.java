package guru.qa.HW16Owner;

import guru.qa.HW16Owner.config.AndroidConfig;
import guru.qa.HW16Owner.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeviceTest {
    @Test
    public void testAndroid() {
        System.setProperty("device", "pixel");
        MobileConfig config = ConfigFactory
                .create(MobileConfig.class, System.getProperties());

        assertThat(config.platformName()).isEqualTo("Android");
        assertThat(config.platformVersion()).isEqualTo("27.0");
        assertThat(config.deviceName()).isEqualTo("Google Pixel XL");
    }

    @Test
    public void testIphone() {
        System.setProperty("device", "iphone12");
        MobileConfig config = ConfigFactory
                .create(MobileConfig.class, System.getProperties());

        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("14.0");
        assertThat(config.deviceName()).isEqualTo("IPhone 12 Pro Max Ultra High");
    }
}
