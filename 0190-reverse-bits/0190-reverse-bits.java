class Solution {
    public int reverseBits(int n) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | (n & 1);
            n >>>= 1;
        }

        return ans;
    }
}

// public int reverseBits(int n) {

//     int[] bits = new int[32];

//     for (int i = 0; i < 32; i++) {
//         bits[i] = n & 1;
//         n >>= 1;
//     }

//     int ans = 0;

//     for (int i = 0; i < 32; i++) {
//         ans = (ans << 1) | bits[i]; // it helps to insert that bits[i] into the ans
//     }

//     return ans;
// }