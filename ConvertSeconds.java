package Homework5;

import java.util.Random;

public class ConvertSeconds {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(0,28801);
        System.out.println("There are " + n + " seconds left till the end of the working day");

        int secondsInMinute = 60;
        int minutesInHour = 60;

        int nConvertMinutes  = n / secondsInMinute ;
        int nConvertHours = nConvertMinutes / minutesInHour;

       if(nConvertHours > 1 && nConvertHours <= 8) {
           System.out.println("There are " + nConvertHours + " hours left till the end of your working day");
       } else {
           if (nConvertHours == 1) {
               System.out.println("There is " + nConvertHours + " hour left till the end of your working day");
           } else {
               System.out.println("There is less then hour left till the end of your working day");
           }
       }
    }
}
