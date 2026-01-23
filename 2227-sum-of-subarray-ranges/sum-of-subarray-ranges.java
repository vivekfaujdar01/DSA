class Solution {
    // contribution = nums[i] × (i - leftBoundary) × (rightBoundary - i)
    // Sum(Max - Min) = sum of max - sum of min;
    // we are calculation nextGreaterOrEqual and nextSmallerOrEqual because of that one element is counted by only one time
    static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    static int[] nextGreaterOrEqual(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }
    static int[] previousSmaller(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    static int[] nextSmallerOrEqual(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] pg = previousGreater(nums);;
        int[] ngOrEqual = nextGreaterOrEqual(nums);
        int[] ps = previousSmaller(nums) ;
        int[] nsOrEqual = nextSmallerOrEqual(nums);
        long maxSum = 0, minSum = 0;

        for (int i = 0; i < n; i++) {
            long leftMax = i - pg[i];
            long rightMax = ngOrEqual[i] - i;
            maxSum += nums[i] * leftMax * rightMax;

            long leftMin = i - ps[i];
            long rightMin = nsOrEqual[i] - i;
            minSum += nums[i] * leftMin * rightMin;
        }

        return maxSum - minSum;
    }
}