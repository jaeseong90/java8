package me.jaeseong.java8.DateAndTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateEx {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("------------------------------------------기존");
        Date date = new Date();
        long time = date.getTime(); //이폭 타임

        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = new GregorianCalendar(2022, Calendar.JULY, 27) ;
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000*1);
        date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        date.setTime(time);

        System.out.println(date);
        System.out.println(date.getTime());

        System.out.println("------------------------------------------Instant");
        Instant instant = Instant.now(); //기준시 UTC, GMT 같은 값
        System.out.println(instant);
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        System.out.println(instant.atZone(ZoneId.of("UTC")));
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        System.out.println("------------------------------------------LocalDateTime");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime birthDay = LocalDateTime.of(1990, Month.APRIL,17,0,0);
        System.out.println(birthDay);

        System.out.println("------------------------------------------Period");
        LocalDate today = LocalDate.now();
        LocalDate bir = LocalDate.of(1990,04,17);
        Period period = Period.between(bir,today);
        System.out.println(period.getDays());
        Period until = bir.until(today);
        System.out.println(until.get(ChronoUnit.DAYS));

        System.out.println("------------------------------------------Duration");
        Instant instantNow = Instant.now();
        Instant instantPlus = instantNow.plus(10,ChronoUnit.SECONDS);
        Duration duration = Duration.between(instantNow,instantPlus);
        System.out.println(duration.getSeconds());

        System.out.println("------------------------------------------formmat");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter1 = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(localDateTime.format(formatter));
        System.out.println(localDateTime.format(formatter1));

        //parsing
        LocalDate parse = LocalDate.parse("1990-04-17",formatter);
        System.out.println(parse);

    }
}
