package Homework3;

import java.util.Scanner;
public class Converter {

    public void getFahrenheitAndKelvin(double celsius) {
       double fahrenheit = celsius * 1.8 + 32;
       double kelvin = celsius + 273.15;
       System.out.println(celsius + " celsius is equal to " + fahrenheit + " fahrenheit");
       System.out.println(celsius + " celsius is equal to " + kelvin + " kelvin.");

    }

    public double getFahrenheit2(double celsius) {
        double fahrenheit2 = celsius * 1.8 + 32;
        return fahrenheit2;
    }
    public double getKelvin2(double celsius) {
        double kelvin2 = celsius + 273.15;
        return kelvin2;
    }
}

