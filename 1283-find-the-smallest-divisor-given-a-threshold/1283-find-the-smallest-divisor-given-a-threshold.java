class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);

        int left = 1;
        int right = nums[nums.length-1];
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canDivisor(nums, mid, threshold)){
                ans = mid;
                right = mid - 1;
            } 
            else{
                left = mid + 1;
            } 
        }
        return ans;
    }

    public boolean canDivisor(int[] nums, int div, int threshold){
        long ans = 0;
        for(int num : nums){
            int a = num / div;
            ans += a;
            if(num % div != 0) ans++;
        }
        return ans <= threshold;
    }
}