class Solution {

    // Approach (nextSmaller)
    // this problem is based on finding nextSmaller 
    // after finding the next smaller just substract it from the current element
    public int[] nextSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            int ans = st.isEmpty() ? arr[i] : arr[i] - arr[st.peek()];
            res[i] = ans;
            st.push(i);
        }

        return res;
    }
    public int[] finalPrices(int[] prices) {
        return nextSmaller(prices);
    }
}