package Binary_Search;

public class UpperBound {
    static public int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // or right, since left == right
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 6};
        int target = 4;
        int result = upperBound(arr, target);
        System.out.println("Upper Bound index of " + target + " is: " + result); // Output: 4
    }
}

// Time Complexity: O(log n)
// Space Complexity: O(1)
// The upper bound of a number is defined as the smallest index in the sorted array where the element is greater than the given number.