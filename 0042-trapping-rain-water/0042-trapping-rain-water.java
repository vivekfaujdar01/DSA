class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int totalWater = 0;

        int leftMax = 0;
        int rightMax = 0;

        int start = 0;
        int end = n - 1;

        while (start < end) {

            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);

            if (leftMax < rightMax) {

                totalWater += leftMax - height[start];
                start++;

            } else {

                totalWater += rightMax - height[end];
                end--;
            }
        }

        return totalWater;
    }
}

// public int trap(int[] height) {
//     int n = height.length;

//     int[] leftMax = new int[n];
//     int[] rightMax = new int[n];

//     leftMax[0] = height[0];
//     for (int i = 1; i < n; i++) {
//         leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//     }

//     rightMax[n - 1] = height[n - 1];
//     for (int i = n - 2; i >= 0; i--) {
//         rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//     }

//     int water = 0;
//     for (int i = 0; i < n; i++) {
//         water += Math.min(leftMax[i], rightMax[i]) - height[i];
//     }

//     return water;
// }
