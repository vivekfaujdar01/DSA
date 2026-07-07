class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                ans = Math.min(ans, nums[mid]);  
                right = mid;
            } else {
                ans = Math.min(ans, nums[right]);  
                left = mid + 1;
            }
        }

        return ans;
    }
}