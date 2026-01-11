class Solution {
    public int largestRectangleArea(int[] heights) {
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