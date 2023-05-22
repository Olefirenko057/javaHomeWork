public class DefineConstructor {
    double width;
    double height;
    double length;


    public DefineConstructor(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
        double volume = width * height * length;
        System.out.println("volume: " + volume);
    }
}
