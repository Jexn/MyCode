package Day13;

import org.junit.Test;

public class MyTest {
    @Test
    public void defineEnumTest() {
        SeasonEnumDefine spring = SeasonEnumDefine.SPRING;
        System.out.println(spring);
    }

    @Test
    public void EnumTest() {
        SeasonEnum seasonEnum = SeasonEnum.SPRING;
        SeasonEnum[] values = seasonEnum.values();
        for (SeasonEnum value : values) {
            System.out.println(value);
        }

        SeasonEnum seasonEnum1 = seasonEnum.valueOf("SPRING");
        System.out.println(seasonEnum1);
        System.out.println("seasonEnum.getSEASON_NAME() = " + seasonEnum.getSEASON_NAME());
        System.out.println("seasonEnum.getSEASON_DESC() = " + seasonEnum.getSEASON_DESC());
        System.out.println("seasonEnum = " + seasonEnum);
    }
}
