class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = 0, n = heights.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int height = heights[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                int area = height * (right - left - 1);
                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int height = heights[st.pop()];
            int right = n;
            int left = st.isEmpty() ? -1 : st.peek();
            int area = height * (right - left - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}