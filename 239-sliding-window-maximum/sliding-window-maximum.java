class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        // Deque to store indices
        // Monotonic Deque (O(n))
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            
            // 1. Remove elements out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // 2. Remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            // 3. Add current index
            dq.offerLast(i);
            
            // 4. Add max to result once window is valid
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }
        
        return result;
    }
}
