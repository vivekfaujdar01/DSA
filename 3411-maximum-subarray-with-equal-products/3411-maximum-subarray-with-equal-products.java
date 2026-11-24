// lcm = a*b / gcd(a*b)
class Solution {

    public int maxLength(int[] nums) {

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                long product = 1;
                long gcd = nums[i];
                long lcm = nums[i];

                for (int k = i; k <= j; k++) {

                    product *= nums[k];

                    if (k > i) {
                        gcd = findGCD(gcd, nums[k]);

                        lcm = (lcm * nums[k]) / findGCD(lcm, nums[k]);
                    }
                }

                if (product == gcd * lcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private long findGCD(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
