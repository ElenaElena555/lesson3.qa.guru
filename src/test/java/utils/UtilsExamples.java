package utils;

import static utils.RandomUtils.*;

public class UtilsExamples {
    public static void main(String[] args) {
        System.out.println("Random string:" + getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(("Random int:" + getRandomInt(22, 22222)));
    }
}
