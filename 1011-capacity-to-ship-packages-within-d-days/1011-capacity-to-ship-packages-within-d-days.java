class Solution {
    // Binary Search on Answers
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;              
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;       
                right = mid - 1;
            } else {
                left = mid + 1;   
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int daysUsed = 1;
        int currentWeight = 0;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {
                daysUsed++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }

        return daysUsed <= days;
    }
}