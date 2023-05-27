package Homework4;

public class Calories {

    float diam;
    float calories = 40;

    public Calories(float diam) {
        this.diam = diam;
    }

     public void areaOfPizza() {
         float area = (float) (Math.PI * (diam * 2));
         calories = area * calories;
         System.out.println("Pizza with the area of " + area + " square centimeters involves " + calories + " calories.");
     }
}
