class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    ans++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, boolean[][] vis, int r, int c){
        if(r>=grid.length || r< 0 || c >= grid[0].length || c< 0 || vis[r][c] == true || grid[r][c] == '0') return;

        vis[r][c] = true;

        //r-1,c
        dfs(grid, vis, r-1,c);

        //r+1,c
        dfs(grid, vis, r+1,c);

        //r,c-1
        dfs(grid, vis, r,c-1);

        //r,c+1
        dfs(grid, vis, r,c+1);

    }
}