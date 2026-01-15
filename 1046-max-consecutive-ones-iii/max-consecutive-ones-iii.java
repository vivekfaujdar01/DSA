class Solution {
    public int longestOnes(int[] nums, int k) {

        // Approach (sliding window)
        // shrink the window if count0 > k so increase start++;
        // everytime check length by Math.max(maxLength, end-start+1);
        int start = 0, maxLen = 0, count0 = 0 ;
        for(int end=0; end<nums.length ; end++){
            if(nums[end] == 0){
                count0++;
            }
            while(count0 > k){
                if(nums[start] == 0){
                    count0--;
                }
                start++;
            }

            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
    }
}