class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Approach (Sliding Window | Dynamic size window)
        int start = 0; 
        int sum = 0;
        int min = 1000001;
        for(int end = 0; end < nums.length; end++){
            sum += nums[end];

            while(sum >= target){
                min = Math.min(min, end-start+1);
                sum -= nums[start];
                start++;
            }

        }
        if(min == 1000001) return 0;
        return min;
    }
}