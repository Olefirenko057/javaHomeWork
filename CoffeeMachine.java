package Homework7;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick the drink you want(1 - espresso, 2 - americano, 3 - cappuccino, 4 - tea): ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                System.out.println("You have selected espresso");
                System.out.println(getEspresso());
                System.out.println(finish());
                break;


            case 2:
                System.out.println("You have selected americano");
                System.out.println(getAmericano());
                break;

            case 3:
                System.out.println("You have selected cappuccino");
                System.out.println(getCappuccino());
                break;

            case 4:
                System.out.println("You have selected tea");
                System.out.println(getTea());

                break;

            default:
                System.out.println("You have picked invalid number");
        }
    }


    public static String getEspresso() {
        return "\tpouring espresso";
    }

    public static String getAmericano() {
       String result = getEspresso();
       result += "\n";
       result += getWater();
       result += "\n";
       result += finish();
       return result;
    }

    public static String getCappuccino() {
        String result = getEspresso();
        result += "\n";
        result += "\tadd some foam milk";
        result += "\n";
        result += finish();
        return result;
    }

    public static String getTea() {
        String result = "\tPicking tea package";
        result += "\n";
        result += getWater();
        result += "\n";
        result += finish();
        return result;

    }

    public static String getWater() {
        return "\tadd some water";
    }

    public static String finish() {
        return "Your drink is ready";
    }


}
