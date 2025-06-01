public class PowerOfTwo {
    static boolean isPowerofTwo(int n) {
        if (n <= 0)
            return false;
        
        while (n > 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 16;
        if (isPowerofTwo(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
