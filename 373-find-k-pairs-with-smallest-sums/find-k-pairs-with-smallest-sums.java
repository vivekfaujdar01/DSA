import java.util.*;

class Solution {
    // Logic:
    // nums1 and nums2 are sorted, so pair sums form a sorted 2D grid.
    // Use a Min Heap to always extract the next smallest sum pair.
    // Start with the smallest pair (0, 0).
    // From a pair (i, j), only two next candidates are possible:
    //    1) (i + 1, j)
    //    2) (i, j + 1)
    // Use a visited set to avoid pushing the same index pair twice.
    // Repeat k times to collect k smallest pairs.
    
    static class Pair {
        int i, j;
        long sum;

        Pair(int i, int j, long sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>((a, b) -> Long.compare(a.sum, b.sum));

        Set<String> visited = new HashSet<>();

        minHeap.offer(new Pair(0, 0, (long) nums1[0] + nums2[0]));
        visited.add("0#0");

        while (k > 0 && !minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            int i = curr.i;
            int j = curr.j;

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Next row
            if (i + 1 < nums1.length) {
                String key = (i + 1) + "#" + j;
                if (!visited.contains(key)) {
                    minHeap.offer(new Pair(
                            i + 1,
                            j,
                            (long) nums1[i + 1] + nums2[j]
                    ));
                    visited.add(key);
                }
            }

            // Next column
            if (j + 1 < nums2.length) {
                String key = i + "#" + (j + 1);
                if (!visited.contains(key)) {
                    minHeap.offer(new Pair(
                            i,
                            j + 1,
                            (long) nums1[i] + nums2[j + 1]
                    ));
                    visited.add(key);
                }
            }
        }

        return result;
    }
}
