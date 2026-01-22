class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temp.length];
        for(int i=temp.length-1;i>=0;i--){
            while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
                st.pop();
            }

            res[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }

        return res;
    }
}