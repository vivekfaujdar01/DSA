class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Approach (Sliding Window)
        int max = nums[0];
        for(int i=0;i<k;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int[] res = new int[nums.length-k+1];
        res[0] = max;
        int left = 0;
        for(int i = k;i < nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
            res[i-k+1] = max;
            left++;
        }
        return res;
    }
}