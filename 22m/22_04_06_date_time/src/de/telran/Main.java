package de.telran;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Первый вид дат и времени.
        // LocalDate - описывает дату без привязки к часовому поясу.
        // LocalTime - описывает время без привязки к часовому поясу.
        // LocalDateTime - описывает дату + время без часового пояса.

        // System.currentTimeMillis() - функция, которая возвращает количество милисекунд, прошедших с 00:00 1
        // января 1970 года в UTC


        // LocalDate
        // как создать объект с локальной датой
        LocalDate today = LocalDate.now();
        LocalDate myBirthday = LocalDate.parse("1985-08-01");// (yyyy-mm-dd)
        LocalDate fromYMD = LocalDate.of(2011, 8, 18);
        System.out.println(fromYMD);

        System.out.println(today);
        System.out.println(myBirthday);

        // можно складывать/вычитать временные периоды
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
        LocalDate todayNextMonth = today.plusMonths(1);
        System.out.println(todayNextMonth);

        System.out.println(today.plus(37, ChronoUnit.DAYS));

        // можно доставать разлучную информацию о дате, типа день недели и т.п.
        System.out.println(today.getDayOfWeek());
        // можно сравнивать две даты на больше/меньше (isAfter(), isBefore())
        System.out.println(today.isBefore(tomorrow));
        //метод with позволяет получить иную дату на основе данной
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));


        // LocalTime
        // Создать объект

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);
        LocalTime lessonStart = LocalTime.of(9, 30);
        System.out.println(lessonStart);
        // складывать/вычитать временные периоды
        System.out.println(currentTime.plus(1, ChronoUnit.HOURS));
        // разлиные getters
        System.out.println(currentTime.getHour());
        // сравнивать isBefore()/isAfter()

        System.out.println(currentTime.isBefore(lessonStart));
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);

        // LocalDateTime - совмещает в себе все возможности LocalDate и LocalTime

        LocalDateTime combinedNow = LocalDateTime.of(today, currentTime);
        System.out.println(combinedNow);
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("1985-08-01T01:00");
        System.out.println(parsedLocalDateTime);

        // ZonedDateTime - объект, несущий в себе информацию о дате и времени, с привязкой к часовому поясу
        ZonedDateTime nowZonedBerlin = ZonedDateTime.of(combinedNow, ZoneId.of("Europe/Berlin"));
        System.out.println(nowZonedBerlin);
        // Чтобы узнать о доступных ZoneId, можно распечатать ZoneId.getAvailableZoneIds()
        System.out.println(ZoneId.getAvailableZoneIds());

        // поменять зону
        // перевод часов
        ZonedDateTime nowZonedNewYork = nowZonedBerlin.withZoneSameInstant(ZoneId.of("US/Eastern"));
        System.out.println(nowZonedNewYork);
        // подмена зоны
        System.out.println(nowZonedBerlin.withZoneSameLocal(ZoneId.of("US/Eastern")));
        // перевод из миллисекунд в ZonedDateTime
        ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("US/Eastern"));


        // Period - класс, описывающий временные периоды для работы с датами. Периоды описываются в виде
        // года, месяцы, дни
        System.out.println(today.plus(Period.ofDays(15)));
        Period period = Period.between(myBirthday, today);
        System.out.println(period);
        System.out.println(period.getDays());

        // количество именно дней между двумя датами
        System.out.println(ChronoUnit.DAYS.between(myBirthday, today));
        System.out.println(ChronoUnit.DAYS.between(today, myBirthday));

        // Duration - класс, описывающий временные периоды для работы со временем.
        Duration fromStart = Duration.between(currentTime, lessonStart);
        System.out.println(fromStart);
        System.out.println(fromStart.getSeconds());


        // Форматирование DateTimeFormatter - класс, описывающий правило для перевода времени и даты
        // в строку и обратно

        // LocalDate -> String
        DateTimeFormatter slashFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(slashFormatter.format(today));
        // String -> LocalDate
        LocalDate fromSlashFormatter = LocalDate.parse("2022/04/06", slashFormatter);
        System.out.println(fromSlashFormatter);

        DateTimeFormatter macFormatter = DateTimeFormatter.ofPattern("EE d MMM");
        System.out.println(macFormatter.format(today));
    }
}
