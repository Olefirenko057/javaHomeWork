import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number of week's day: ");

        int dayOfWeek = sc.nextInt();

        if(dayOfWeek == 1) {
            System.out.println("Monday");
        } else if (dayOfWeek == 2) {
            System.out.println("Tuesday");
        } else if (dayOfWeek == 3) {
            System.out.println("Wednesday");
        } else if (dayOfWeek == 4) {
            System.out.println("Thursday");
        } else if (dayOfWeek == 5) {
            System.out.println("Friday");
        } else if (dayOfWeek == 6) {
            System.out.println("Saturday");
        } else if (dayOfWeek == 7) {
            System.out.println("Sunday");
        } else {
            System.out.println("Incorrect number");
        }
    }
}
