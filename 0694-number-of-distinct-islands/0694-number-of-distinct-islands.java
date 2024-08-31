class Solution {
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];

        Set<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j = 0; j < m ;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(grid,visited,i,j,i,j,list,n,m);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int[][] visited, int row, int col, int row0, int col0, ArrayList<String> list, int n, int m){
        visited[row][col] = 1;
        list.add(Integer.toString(row-row0)+" "+Integer.toString(col-col0));

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<4;i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(newRow >=0 && newRow < n && newCol >=0 && newCol < m && grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0){
                dfs(grid,visited,newRow, newCol, row0,col0, list, n,m);
            }
        }


    }


}