package guru.qa.HW16Owner;

import guru.qa.HW16Owner.config.FruitsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FruitsTest {
    @Test
    public void testArray(){
        System.setProperty("array", "apple, banana, orange");
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArray()).containsExactly("apple","banana","orange");
    }
    @Test
    public void testDefault(){
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getArrayDefault()).containsExactly("apple","banana","orange");
    }

    @Test
    public void testSeparator(){
        System.setProperty("separator", "apple;banana;orange");
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getArraySeparator()).containsExactly("apple","banana","orange");
    }
}
