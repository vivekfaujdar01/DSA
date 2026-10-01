class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //we will declare a maxheap which will sort the points in descending order on the basis of distance, 
        //and heap will have only k closest points from origin
        //here we are finding distance by x*x + y*y

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] num : points) {
            maxHeap.add(num);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        int i = 0;

        while (maxHeap.isEmpty() == false) {
            result[i++] = maxHeap.poll();
        }

        return result;
    }
}