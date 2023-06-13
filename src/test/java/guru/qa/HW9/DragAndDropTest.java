package guru.qa.HW9;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void checkDragDropOption(){
    // Откройте https://the-internet.herokuapp.com/drag_and_drop
   open("https://the-internet.herokuapp.com/drag_and_drop");
     //Перенесите прямоугольник А на место В
    $("#column-a").dragAndDropTo($("#column-b"));

      //Проверьте, что прямоугольники действительно поменялись
        $$("#column-a").find(text("B")).shouldBe(visible);
        $$("#column-b").find(text("A")).shouldBe(visible);
    }
}
