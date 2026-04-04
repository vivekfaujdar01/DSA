class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0], curMin = nums[0], ans = nums[0];
        //Need to track both min and max (because negative flips sign).
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            // We will swap currMax and currMin if nums[i] is negative
            if (x < 0) {
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(x, curMax * x);
            curMin = Math.min(x, curMin * x);
            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}