class Solution {
    public int maxArea(int[] height) {
        // Approach
        // Actually we have to find maxArea , area = width * height
        // here, width = right - left
        // height = min(height[left], height[right])
        // we will check maxArea everytime then
        // we will check that in which direction we will go on the basis of height
        int width = 0;
        int ht = 0;
        int maxArea = 0;
        int left = 0,right = height.length - 1;
        while(left < right){
            width = right - left;
            ht = Math.min(height[left], height[right]);
            int currArea = ht * width;
            maxArea = Math.max(currArea, maxArea);
            if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
}