class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i){
            L[i] = arr[l + i];
        }
            
        for (int j = 0; j < n2; ++j){
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;   // Initial indices of first and second subarrays

        int k = l;  // Initial index of merged subarray array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        while (i < n1) {    // Copy remaining elements of L[] if any
            arr[k] = L[i];
            i++;
            k++;
        }
   
        while (j < n2) {    // Copy remaining elements of R[] if any
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
}