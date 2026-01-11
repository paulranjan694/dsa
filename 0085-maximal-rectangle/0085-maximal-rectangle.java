class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length, maxArea=0;

        int[] heights = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '0'){
                    heights[j]=0;
                }else{
                    heights[j]++;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int maxArea = 0,n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            int currHeight = heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currHeight){
                int height = heights[stack.pop()];
                int nse=i;
                int pse = stack.isEmpty()? -1 : stack.peek();
                int width = (nse - pse -1);
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int nse=n;
            int pse = stack.isEmpty()? -1 : stack.peek();
            int width = (nse - pse -1);
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}