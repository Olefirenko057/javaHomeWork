package Homework3;

import java.util.Scanner;

public class ConverterTest {
    public static void main(String[] args) {
        System.out.print("Enter today's celsius degree: ");
        Scanner sc = new Scanner(System.in);
        double celsius = sc.nextDouble();

        Converter conv = new Converter();
        conv.getFahrenheitAndKelvin(celsius);
        System.out.println(conv.getFahrenheit2(celsius));
        System.out.println(conv.getKelvin2(celsius));

    }

}
