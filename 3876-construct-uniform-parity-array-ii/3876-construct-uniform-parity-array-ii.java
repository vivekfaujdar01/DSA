// Since the minimum element determines the parity of nums 2:
//     An odd minimum → all elements can be made odd.
//     An even minimum → possible only when all elements are even.
// the valid construction is possible when:
//     The min element is ODD
//     OR
//     All elements are EVEN
class Solution {
    public boolean uniformArray(int[] A) {
        int min = A[0], odd = 0;

        for (int x : A) {
            min = Math.min(min, x);
            odd |= x & 1;
        }

        return (min & 1) == odd;
    }
}