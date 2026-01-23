class Solution {
    //Put 1 into heap
    // Repeat n times:
    // Pop smallest element → this is the next ugly number
    // Multiply it by 2, 3, 5
    // Add results to heap if not already seen
    // The last popped element is the answer
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();

        pq.add(1L);
        seen.add(1L);

        long curr = 1;

        for (int i = 0; i < n; i++) {
            curr = pq.poll();

            for (int f : new int[]{2, 3, 5}) {
                long next = curr * f;
                if (seen.add(next)) {
                    pq.add(next);
                }
            }
        }
        return (int) curr;
    }
}
