class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean[][] visited = new boolean[n][m];
                if(grid[i][j] != 0){
                    max = Math.max(dfs(grid,i,j,visited,n,m),max);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited, int n, int m){
        if(grid[i][j]==0) return 0;
        visited[i][j] = true;

        int up = 0, down = 0, left = 0, right = 0;
        
        if(j-1>=0 && !visited[i][j-1]){
            left = dfs(grid,i,j-1,visited,n,m);
        }

        if(j+1<m && !visited[i][j+1]){
            right = dfs(grid, i, j+1, visited,n,m);
        }

        if(i-1>=0 && !visited[i-1][j]){
            up = dfs(grid, i-1, j, visited,n,m);
        }

        if(i+1<n && !visited[i+1][j]){
            down = dfs(grid, i+1, j, visited,n,m);
        }
        int max = Math.max(Math.max(left,right), Math.max(up,down));

        visited[i][j] = false;
        return max + grid[i][j];
    }
}