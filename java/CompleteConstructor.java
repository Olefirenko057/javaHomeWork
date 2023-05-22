import java.util.Scanner;

public class CompleteConstructor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter width: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter length: ");
        double num3 = sc.nextDouble();
        DefineConstructor obj = new DefineConstructor(num1,num2,num3);
        System.out.println("Width: " + obj.width);
        System.out.println("Height: " + obj.height);
        System.out.println("Length: " + obj.length);
//





    }
}
