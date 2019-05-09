package Day20;

import org.junit.Test;

import java.sql.SQLData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeAPI {
    @Test
    public void method1() {
        Date date = new Date();
        System.out.println(date.toString());

        java.sql.Date date1 = new java.sql.Date(12387967123892L);
        System.out.println(date1);
    }

    @Test
    public void method2() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        try {
            date = simpleDateFormat.parse("2019-04-10");
            System.out.println(date);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method3() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");

        Date date = new Date();
        System.out.println("格式化之前：" + date);
        // 格式化
        String now = simpleDateFormat.format(date);
        System.out.println(now);

        // 解析
        try {
            Date date1 = simpleDateFormat.parse(now);
            System.out.println("解析后：" + date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringToSqlDate() throws ParseException {
        String str = "2019年6月15日";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = simpleDateFormat.parse(str);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }

    @Test
    public void flashOrSleep() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = simpleDateFormat.parse("1990-01-01");
        Date endTime = simpleDateFormat.parse("2019-04-10");

        long time = (endTime.getTime() - startTime.getTime()) / (24 * 60 * 60 * 1000);

        System.out.println("speed = " + time);


        int day = ((int) time) % 5;

        System.out.println("day = " + day);
        if (day == 1 || day == 2 || day == 3) {
            System.out.println("打鱼");
        }
        if (day == 0 || day == 4) {
            System.out.println("晒网");
        }
    }
}
