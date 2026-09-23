class Solution {
    // this question is same as finding next permutation 
    public int nextGreaterElement(int n) {
        
        char[] digits = String.valueOf(n).toCharArray();  // Convert number to character array
        
        int i = digits.length - 2; // Find pivot

        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        
        if (i < 0) {    // No greater permutation exists
            return -1;
        }
        // Find smallest digit greater than digits[i]
        int j = digits.length - 1;

        while (digits[j] <= digits[i]) {
            j--;
        }

        // Swap
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        reverse(digits, i + 1, digits.length - 1); // Reverse suffix

        long result = Long.parseLong(new String(digits));  // Convert back to number

        // Check 32-bit integer range
        if (result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}