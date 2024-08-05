class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i<n && j<m && i+1 < n){
                    if(grid[i][j] != grid[i+1][j]) return false;
                }

                if(i<n && j<m && j+1 < m){
                    if(grid[i][j] == grid[i][j+1]) return false;
                }
            }
        }
        return true;
    }
}