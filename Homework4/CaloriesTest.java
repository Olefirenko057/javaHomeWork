package Homework4;

public class CaloriesTest {
    public static void main(String[] args) {
        Calories cal = new Calories(24);
        cal.areaOfPizza();
        double firstCaloriesQuantity = cal.calories;

        Calories cal2 = new Calories(28);
        cal2.areaOfPizza();
        double secondCaloriesQuantity = cal2.calories;

        float caloriesDifference = cal2.calories - cal.calories;
        System.out.println("You will get " + caloriesDifference + " calories more if you buy 28 diametered pizza, instead of 24 one ");
    }
}
