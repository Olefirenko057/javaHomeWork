package Homework8;

public class Numbers {

    // 1 уровень сложности: Разработайте алгоритм с помощью цикла for, который смог бы вывести в консоль такую последовательность чисел:
    //
    //1 2 4 8 16 32 64 128 256 512
    public static void main(String[] args) {
        int i = 1;
        int powResult = 2;
        for(; i <= 512; ) {
            System.out.println(i);
            i*=powResult;
        }
    }
}
