public class CharHomework {
    public static void main(String[] args) {
        char num = '4';

        String value = String.valueOf(num);

        int result = Integer.parseInt(value);

        System.out.println(result + 6);

        int result2 = Character.getNumericValue(num);

        System.out.println(result2 + 6);
    }
}
