public class Sqrt {
    public static void main(String[] args) {
        int n = 17; // Example input
        System.out.println("Square root of " + n + " is: " + sqrt(n));
    }

    public static int sqrt(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number");
        }
        if (n == 0 || n == 1) {
            return n;
        }

        int start = 1, end = n, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid * mid == n) {
                return mid; // Perfect square
            } else if (mid * mid < n) {
                ans = mid; // Update answer
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans; // Return the floor value of the square root
    }
}
