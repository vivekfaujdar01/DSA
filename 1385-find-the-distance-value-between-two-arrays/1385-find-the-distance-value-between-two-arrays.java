// Lower bound returns the index of the first element that is greater than or equal to the target.
// x-d <= y <= x+d
// Therefore:
// If an element exists inside this range, x is NOT far.
// If no element exists inside this range, x is far.
// Time complexity : O(mlog(m) + nlog(m))
class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int x : arr1) {

            int target = x - d;

            int index = lowerBound(arr2, target);

            if (index == arr2.length || arr2[index] > x + d) {

                count++;
            }
        }

        return count;
    }

    private int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}