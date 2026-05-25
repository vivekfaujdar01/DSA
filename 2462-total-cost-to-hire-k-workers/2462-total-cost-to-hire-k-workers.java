class Solution {

    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int n = costs.length;

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }

        long ans = 0;

        while (k-- > 0) {

            int leftMin = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();

            int rightMin = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();

            if (leftMin <= rightMin) {

                ans += leftHeap.poll();

                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }

            } else {

                ans += rightHeap.poll();

                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return ans;
    }
}