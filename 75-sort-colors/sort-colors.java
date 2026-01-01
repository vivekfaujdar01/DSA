class Solution {
    public void sortColors(int[] nums) {
        int left = 0,mid = 0, right = nums.length-1;
        while(mid <= right){
            if(nums[mid] == 0){
                int t = nums[left];
                nums[left] = nums[mid];
                nums[mid] = t;
                left++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                int t = nums[mid];
                nums[mid] = nums[right];
                nums[right] = t;
                right--;
            }
        }
    }
}