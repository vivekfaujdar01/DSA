public class MinInRotatedArray {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element,
            // the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // Otherwise, the minimum is in the left half or at mid
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int output = findMin(input);
        System.out.println(output); // Output: 0
    }
}
