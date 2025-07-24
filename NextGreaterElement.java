// LeetCode Problem 496: Next Greater Element I
// This code finds the next greater element for each element in nums1 based on the elements in nums2.   
import java.util.HashMap;
import java.util.Stack;
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 to find the next greater elements
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Prepare the result for nums1 based on the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nge.nextGreaterElement(nums1, nums2);
        
        for (int res : result) {
            System.out.print(res + " "); // Output: -1 3 -1
        }
    }
}
// This code uses a stack to efficiently find the next greater elements in O(n) time complexity
// where n is the length of nums2. It maps each element in nums2 to its next greater element and then retrieves the results for nums1 based on this mapping.
