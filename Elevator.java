package Homework9;

import java.util.Random;
import java.util.Scanner;

public class Elevator {


    //1 уровень сложности: Лифт, находящийся на первом этаже здания высотой H, должен подняться на последний этаж. Лифт сломан. Каждый раз он поднимается на N этажей и спускается на M этажей. Если на последнем подъёме лифт превысил количество этажей, то считается что лифт поднялся на самый верх. Найдите количество подъёмов, которые понадобятся лифту.

    //H, N, M можно оформить через сканнер. Для теста можно использовать значения, например H = 200, N = 50, M = 1
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter building's height: ");
        int H = sc.nextInt();

        System.out.print("Enter quantity of floors it goes up:");
        int N = sc.nextInt();

        System.out.print("Enter quantity of floors it goes down:");
        int M = sc.nextInt();
        sc.close();

        int currentFloor = 1;
        int floorsUp = N - M;
        int upsQuantity = 0;


        if(H <= N ) {
            System.out.println("Our floor is higher than the building itself. Kind of nonsense");
        }
        else if (M < N) {
            for (; currentFloor < H; ) {
                currentFloor += floorsUp;
                upsQuantity++;
                if(currentFloor >= H) {
                    System.out.println("We are on the top , it is " + currentFloor + " floor");
                    System.out.println("It took us " + upsQuantity + " attempts to get on the peak");
                    break;
                } else {
                    System.out.println(currentFloor);
                }
            }
        } else {
            System.out.println("We won't ever reach the peak if we have more downs than ups or the same quantity of ups and downs");
        }


    }
}
