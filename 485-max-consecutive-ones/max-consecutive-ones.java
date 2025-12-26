class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                curr++;
            }
            if(curr > max){
                max = curr;
            }
            if(nums[i] == 0){
                curr = 0;
            }
        }
        return max;
    }
}