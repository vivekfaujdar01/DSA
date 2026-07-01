class Solution {
    // n & (n - 1) removes the rightmost 1-bit.
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;

        // while(n != 0) {
        //     if((n & 1) == 1) count++;
        //     n = n >>> 1;
        // }
    }
}