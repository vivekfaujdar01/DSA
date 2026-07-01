class Solution {
    // because power of 2 is always having 1 set bit 
    // 8 => 1000
    // a number less than 1 of power 2
    // 7 => 0111
    // when we do & operation on these then we always get 0;
    // 1000 & 0111 = 0000
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}