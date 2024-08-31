class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][] visited = new int[n][m]; 

        Queue<int[][]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            //1st row
            if(grid[0][i] == 1){
                q.add(new int[][]{{0,i}});
                visited[0][i] = 1;
            }

            //last row
            if(grid[n-1][i] == 1){
                q.add(new int[][]{{n-1,i}});
                visited[n-1][i] = 1;
            }
        }

        for(int i=0;i<n;i++){
            //1st col
            if(grid[i][0] == 1){
                q.add(new int[][]{{i,0}});
                visited[i][0] = 1;
            }

            //last col
            if(grid[i][m-1] == 1){
                q.add(new int[][]{{i,m-1}});
                visited[i][m-1] = 1;
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!q.isEmpty()){
            int[][] node = q.poll();
            int r = node[0][0];
            int c = node[0][1];

            for(int i=0;i<4;i++){
                int row = r + dx[i];
                int col = c + dy[i];
                if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && visited[row][col] == 0){
                    q.add(new int[][]{{row,col}});
                    visited[row][col] = 1;
                }
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }
}