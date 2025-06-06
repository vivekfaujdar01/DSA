public class MaxConsecutiveOne {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        // Final check in case the array ends with 1s
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 0, 1, 1, 1};
        int output = findMaxConsecutiveOnes(input);
        System.out.println(output); // Output: 3
    }  
}
