public class ConversionTest {

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.printf("%-10s%-10s | %-10s%-10s%n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("---------------------------------------------");

        for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            double feet = i;
            double meters = j;
            System.out.printf("%-10.1f%-10.3f | %-10.1f%-10.3f%n",
                    feet, footToMeter(feet),
                    meters, meterToFoot(meters));
        }
    }
}

