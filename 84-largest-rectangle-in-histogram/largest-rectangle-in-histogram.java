class Solution {
    public ArrayList<Integer> prevSmaller(int[] arr){
        // Approach (NextSmaller + PrevSmaller)
        // width = nextsmallerIndex - prevsmallerIndex - 1;
        // area = width * height
        // Some Catches in nextSmaller Function
        // When no smaller bar exists on the right,the rectangle can extend till the end of the histogram, that't why i store length of array when stack is empty
        // reversing the array of result in nextSmaller function because we get the result in reverse order for getting right result we will reverse it

        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            int ans = st.isEmpty() ? -1 : st.peek();
            res.add(ans);
            st.push(i);
        }
        return res;
    }
    public ArrayList<Integer> nextSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            int ans = st.isEmpty() ? arr.length : st.peek();
            res.add(ans);
            st.push(i);
        }
        Collections.reverse(res);
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> prevsmaller = new ArrayList<>();
        ArrayList<Integer> nextsmaller = new ArrayList<>();

        prevsmaller = prevSmaller(heights);
        nextsmaller = nextSmaller(heights);

        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int width = nextsmaller.get(i) - prevsmaller.get(i) - 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }

        return maxArea;
    }
}