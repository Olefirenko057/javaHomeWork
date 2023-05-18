import java.util.Scanner;

public class ScannerTask {
    public static void main(String[] args) {

        Scanner entNum = new Scanner(System.in);

        int num = entNum.nextInt();

        System.out.println(num);
        System.out.println(Integer.toOctalString(num));
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toHexString(num));
    }
}
