import java.util.Scanner;

public class CalendarGenerator {

    static String[] months = {
        "January", "February", "March", "April", "May", "June", 
        "July", "August", "September", "October", "November", "December"
    };

    static int[] daysInMonth = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int d = 1; 
        int f = d + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + 5 * j;
        return f % 7; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        System.out.println("\n   " + months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDayOfMonth(month, year);
        firstDay = (firstDay + 6) % 7;

        int days = getDaysInMonth(month, year);

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    "); 
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        sc.close();
    }
}
