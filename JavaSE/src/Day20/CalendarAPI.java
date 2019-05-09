package Day20;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarAPI {
    @Test
    public void method1() {
        Calendar calendar = Calendar.getInstance();

        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("calendar.get(Calendar.DAY_OF_WEEK) = " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("calendar.get(Calendar.DAY_OF_YEAR) = " + calendar.get(Calendar.DAY_OF_YEAR));
        // 修改时间
        calendar.set(Calendar.DAY_OF_MONTH, 22);

        // 转成Date
        Date date = calendar.getTime();
        System.out.println(date);

        // 转换成Calendar
        calendar.setTime(date);

    }

    @Test
    public void calendarBug() {

        // 有偏移量，年份是从1900年开始，月份从0开始
        Date date = new Date(2020 - 1900, 8 - 1, 1);
        System.out.println(date);
    }
}
