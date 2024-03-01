package sit707_tasks;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 31-Jan-2024 23:59:59 date increase
        System.out.println("Example with date and time increment from January 31, 2024, 23:59:59.");
        DateUtil date = new DateUtil(31, 1, 2024, 23, 59, 59);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        // 1-Jan-2024 00:00:00 date decrease
        System.out.println("\nExample with date and time decrement from January 1, 2024, 00:00:00.");
        date = new DateUtil(1, 1, 2024, 0, 0, 0);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        // random date
        System.out.println("\nExample with random day in January 2024 and time increment.");
        int randDay = 1 + new Random().nextInt(31); // Random day between 1 and 31
        date = new DateUtil(randDay, 1, 2024, 12, 30, 30);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);
    }
}
