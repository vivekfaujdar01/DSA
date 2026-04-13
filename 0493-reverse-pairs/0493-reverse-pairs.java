class Solution {
    // the logic for this question is more like count inversions the difference is just the condition, in count inversion condition is nums[i] > nums[j]
    // but in this condition is nums[i] > 2*nums[j];
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;

        int count = 0;

        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);

        count += countPairs(nums, left, mid, right);

        merge(nums, left, mid, right);

        return count;
    }

    private int countPairs(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;
        // core logic here is, If condition is true for some j, then it will also be true for all previous j's
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) { // using 2L to avoid overflow
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }


    public void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}