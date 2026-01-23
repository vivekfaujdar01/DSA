class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Convert the 2D problem into multiple 1D problems
        // We reuse the “Largest Rectangle in Histogram” problem for each row of the matrix.
        // heights[j] = number of continuous '1's vertically above (including current row) in column j
        // Think of each column as a vertical bar.
        // We are pretending that each row is the bottom of a histogram.
        // Each column → one histogram bar
        // Height of bar → how many consecutive 1s going UP
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
    
    private int[] prevSmaller(int[] heights) {

        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }

    private int[] nextSmaller(int[] heights) {

        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }
    private int largestRectangleArea(int[] heights) {

        int[] pse = prevSmaller(heights);
        int[] nse = nextSmaller(heights);
    
        int maxArea = 0;
    
        for (int i = 0; i < heights.length; i++) {
        
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
    
            maxArea = Math.max(maxArea, area);
        }
    
        return maxArea;
    }

}