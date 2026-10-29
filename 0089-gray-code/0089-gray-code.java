// Direct Formula G(i) = i ^ (i >> 1);
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);
            result.add(gray);
        }

        return result;
    }
}

// G{n+1} = Gn + {reverse}(Gn) + 2^n

// class Solution {
//     public List<Integer> grayCode(int n) {
//         List<Integer> result = new ArrayList<>();

//         // Base case: 0-bit starting sequence
//         result.add(0);

//         // Build the sequence one bit at a time
//         for (int i = 0; i < n; i++) {
//             int size = result.size();
//             int prefix = 1 << i;

//             // Traverse the existing sequence in reverse
//             for (int j = size - 1; j >= 0; j--) {
//                 result.add(result.get(j) + prefix);
//             }
//         }

//         return result;
//     }
// }
