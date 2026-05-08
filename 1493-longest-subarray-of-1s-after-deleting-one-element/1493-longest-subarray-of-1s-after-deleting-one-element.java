class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, max = 0, count = 0;
        
        for(int end = 0;end < nums.length; end++){

            if(nums[end] == 0){
                count++;
            }

            while(count > 1){
                if(nums[start] == 0){
                    count--;
                }
                start++;
            }

            max = Math.max(max, end - start); // for total window size we use end-start+1 but in this we need 1 less window size because of deletion of 0
        }

        return max;
    }
}