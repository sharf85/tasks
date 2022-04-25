import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

public class Solution {

    public static void main(String... args) {
        LocalDate today = LocalDate.now();

        // 1. Узнать день недели, в котором вы родились
        LocalDate birthday = LocalDate.of(1985, 8, 1);
        System.out.println(birthday.getDayOfWeek());

        // 2. Узнать количество дней до нового года, при условии, что нельзя явно указывать год.
        System.out.println(getDaysNumberTillNewYear(today));

        // 3. Узнать количество дней до дня рождения, при уловии, что дан только день рождения без года.
        System.out.println(getDaysNumberTillBirthday(today, 1, 1));

        printIntArray(new int[]{1, 2, 3});
        printIntArray(3, 2, 1);

    }

    public static void printIntArray(int... numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static int getDaysNumberTillNewYear(LocalDate date) {
        LocalDate endOfYear = date.with(TemporalAdjusters.lastDayOfYear());
        return (int) ChronoUnit.DAYS.between(date, endOfYear);
    }

    public static int getDaysNumberTillBirthday(LocalDate date, int birthdayMonth, int birthdayDayOfMonth) {
        LocalDate birthday = LocalDate.of(date.getYear(), birthdayMonth, birthdayDayOfMonth);

        if (birthday.isAfter(date)) {
            return (int) ChronoUnit.DAYS.between(date, birthday);
        } else {
            LocalDate nextBirthday = birthday.withYear(birthday.getYear() + 1);
            return (int) ChronoUnit.DAYS.between(date, nextBirthday);
        }
    }

}
