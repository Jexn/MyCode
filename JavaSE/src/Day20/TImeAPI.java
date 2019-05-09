package Day20;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TImeAPI {
    @Test
    public void method1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
        System.out.println("localDateTime = " + localDateTime);

        LocalDateTime defineTime = LocalDateTime.of(2020,10,1,10,9,12);
        System.out.println(defineTime);

        System.out.println("localDateTime.getDayOfMonth() = " + localDateTime.getDayOfMonth());
        System.out.println("localDateTime.getDayOfMonth() = " + localDateTime.getMonthValue());
    }
}
