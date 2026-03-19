class Solution {
    // After deletion -> right side even becomes odd and odd becomes even index
    public int waysToMakeFair(int[] arr) {
        int n = arr.length;

        int[] evenPrefix = new int[n];
        int[] oddPrefix = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                evenPrefix[i] = arr[i];
                oddPrefix[i] = 0;
            } else {
                evenPrefix[i] = evenPrefix[i - 1];
                oddPrefix[i] = oddPrefix[i - 1];

                if (i % 2 == 0) {
                    evenPrefix[i] += arr[i];
                } else {
                    oddPrefix[i] += arr[i];
                }
            }
        }

        int totalEven = evenPrefix[n - 1];
        int totalOdd = oddPrefix[n - 1];

        int count = 0;

        for (int i = 0; i < n; i++) {

            int leftEven = (i > 0) ? evenPrefix[i - 1] : 0;
            int leftOdd = (i > 0) ? oddPrefix[i - 1] : 0;

            int rightEven = totalEven - evenPrefix[i];
            int rightOdd = totalOdd - oddPrefix[i];

            int newEven = leftEven + rightOdd;
            int newOdd = leftOdd + rightEven;

            if (newEven == newOdd) {
                count++;
            }
        }

        return count;
    }
}