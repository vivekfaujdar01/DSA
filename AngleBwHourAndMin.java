// Java program to find the minimum angle between hour and minute hands of a clock
            // second half with first half
            
public class AngleBwHourAndMin {
    // Utility function to return the minimum of two double values
    static double getMin(double x, double y) {
        return (x < y) ? x : y;
    }

    // Function to calculate the minimum angle between
    // hour and minute hands
    static double getAngle(String s) {
        // Extract hours and minutes from "HH:MM"
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));

        // Convert 24-hour time to 12-hour format
        h = h % 12;

        // Hour hand moves 0.5 degrees per minute 
        // (30 degrees per hour)
        double hrAngle = 0.5 * (h * 60 + m);

        // Minute hand moves 6 degrees per minute
        double minAngle = 6 * m;

        // Find the absolute difference between the two angles
        double angle = Math.abs(hrAngle - minAngle);

        // Return the smaller angle of the two possible angles
        return getMin(360 - angle, angle);
    }

    public static void main(String[] args) {
        String s = "06:00";
        // double df = 0.0;
        System.out.println(getAngle(s));
    }
}
