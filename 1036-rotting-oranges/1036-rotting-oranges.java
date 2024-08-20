class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int ans = 0;
        int[][] visited = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,-1,0,1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            ans=Math.max(time,ans);
            q.poll();

            for(int i=0;i<4;i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && visited[newRow][newCol] != 2){
                    q.add(new Pair(newRow, newCol, time+1));
                    visited[newRow][newCol]=2;
                    count--;
                }
            }
        }

        return count == 0 ? ans : -1;


    }

    static class Pair{
        int row,col,time;
        Pair(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
}