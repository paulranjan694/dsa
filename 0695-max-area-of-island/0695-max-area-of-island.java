class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, dfs(grid,i,j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1) return 0;
        grid[row][col]=0;
        int res1 = dfs(grid,row+1,col);
        int res2 = dfs(grid,row-1,col);
        int res3 = dfs(grid,row,col+1);
        int res4 = dfs(grid,row,col-1);
        return res1 + res2 + res3 + res4 + 1;
    }
}