class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        dfs(image,ans,color,image[sr][sc],sr,sc);
        return ans;
    }

    private void dfs(int[][] image, int[][] ans, int color, int initColor, int row, int col){
        //base condition
        int n = image.length;
        int m = image[0].length;
        if(row < 0 || row >= n || col < 0 || col >= m || image[row][col] != initColor || ans[row][col] == color) return;

        ans[row][col] = color;
        dfs(image,ans,color,initColor,row+1,col);
        dfs(image,ans,color,initColor,row-1,col);
        dfs(image,ans,color,initColor,row,col+1);
        dfs(image,ans,color,initColor,row,col-1);
        
    }
}