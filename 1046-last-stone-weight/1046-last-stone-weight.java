class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : stones) {
            maxHeap.add(x);
        }

        while (!maxHeap.isEmpty()) {
            int max = maxHeap.poll();

            if (maxHeap.isEmpty()) return max;
            
            int secMax = maxHeap.poll();
            int diff = max - secMax;
            maxHeap.add(diff);
        }

        return 0;
    }
}