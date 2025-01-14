class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length,m=image[0].length;
        int[][] res = image;
        dfs(image,sr,sc,color,image[sr][sc],res,n,m);
        return res;
    }

    private void dfs(int[][] image, int r, int c, int color, int initColor, int[][] res,int n, int m){
        if(r < 0 || r >= n || c < 0 || c >= m || image[r][c] != initColor || res[r][c] == color) return;

        res[r][c] = color;

        dfs(image,r-1,c,color,initColor,res,n,m);//left
        dfs(image,r+1,c,color,initColor,res,n,m);//right
        dfs(image,r,c-1,color,initColor,res,n,m);//up
        dfs(image,r,c+1,color,initColor,res,n,m);//down
    }
}