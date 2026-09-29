class Solution {
    public int getSum(int a, int b) {
        // we will continue this process until carry becomes zero
        while (b != 0) {
            int carry = (a & b) << 1;  // Compute the carry
            a = a ^ b;  // Compute the sum without carry
            b = carry; 
        }
        return a;
    }
}
