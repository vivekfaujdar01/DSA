// This question is same as Search Insert Position in LeetCode
// https://leetcode.com/problems/search-insert-position/description/
// Question No. 35

package Binary_Search;

public class LowerBound {
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 4, 5, 6, 8 };
        int target = 4;
        int result = lowerBound(arr, target);
        System.out.println("Lower bound index of " + target + " is: " + result);
    }
}
// static int lowerBound(int[] arr, int target) {
//         int low = 0, high = arr.length - 1;
//         int res = arr.length;
//
//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//
//             // If arr[mid] >= target, then mid can be the
//             // lower bound, so update res to mid and
//             // search in left half, i.e. [lo...mid-1]
//             if (arr[mid] >= target) {
//                 res = mid;
//                 high = mid - 1;
//             }
            
//             // If arr[mid] < target, then lower bound
//             // cannot lie in the range [lo...mid] so
//             // search in right half, i.e. [mid+1...hi]
//             else {
//                 low = mid + 1;
//             }
//         }
//         return res;
//     }
// The lower bound of a number is defined as the smallest index in the sorted
// array where the element is greater than or equal to the target.
