// LeetCode 215. Kth Largest Element in an Array
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Use a min-heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if we exceed size k
            }
        }
        
        return minHeap.peek(); // The root of the min-heap is the kth largest element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KthLargestElement solution = new KthLargestElement();
        
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();
        
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
        
        scanner.close();
    }
}
// Time Complexity: O(n log k)
// Space Complexity: O(k)
// Note: This solution uses a min-heap to efficiently find the kth largest element without sorting the entire array.