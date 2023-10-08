package Easy;

import org.testng.annotations.Test;

public class _1185_DayoftheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" };
        int diffDays = getDiff(day, month, year);

        return days[diffDays % days.length];
    }

    private int getDiff(int day, int month, int year) {
        // 1971.1.1 = Friday
        int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int res = 0;
        for (int currentYear = 1971; currentYear < year; currentYear++)
            res += isLeap(currentYear) ? 366 : 365;
        for (int currentMonth = 0; currentMonth < month - 1; currentMonth++)
            res += daysOfMonth[currentMonth];

        res += month > 2 && isLeap(year) ? 1 : 0;
        res += day - 1;
        return res;
    }

    public boolean isLeap(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Test
    public void test() {
        System.out.println(dayOfTheWeek(31, 1, 1972));
        System.out.println(dayOfTheWeek(1, 1, 1972));
        System.out.println(dayOfTheWeek(29, 2, 1972));
        System.out.println(dayOfTheWeek(28, 2, 1972));
    }
}
