package guru.qa.HW16Owner;

import guru.qa.HW16Owner.config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthTest {
    @Test
    public void testClassPath() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("sharapova");
        assertThat(config.password()).isEqualTo("123123");
    }

    @Test
    public void testLocalFile() throws IOException {

        // вот это будет происходить в Jenins, вы к этому не имеете доступа
        String content = "username=secret-user\npassword=secret-pass";
        Path propsPath = Paths.get("/tmp/secret.properties");
        Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));
        // вот это будет происходить в Jenins, вы к этому не имеете доступа

        AuthConfig config = ConfigFactory
                .create(AuthConfig.class, System.getProperties());
        assertThat(config.username()).isEqualTo("secret-user");
        assertThat(config.password()).isEqualTo("secret-pass");

        // вот это будет происходить в Jenins, вы к этому не имеете доступа
        Files.delete(propsPath);
        // вот это будет происходить в Jenins, вы к этому не имеете доступа
    }
    }

