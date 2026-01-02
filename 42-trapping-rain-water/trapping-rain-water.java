class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        // first we will check in which side we can trap water in right or left side
        // we check it by comparing left and right side heights
        // then we will check is it the max value in whatever side we will trap water
        // like if we trap water in left side then we will check height[left] is max value or not 
        // if height[left] is max then we will update leftMax
        // if height[ledt] is not max ex-: leftMax > height[left] then we will trap water += leftMax - height[left]
        // same in right side 
        while(left < right){
            if(height[left] < height[right]){
                if(leftMax <= height[left]){
                    leftMax = height[left];
                }
                else{
                    water += leftMax - height[left];
                }
                left++;
            }
            else{
                if(rightMax <= height[right]){
                    rightMax = height[right];
                }
                else{
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}