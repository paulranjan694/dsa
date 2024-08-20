class Solution {
    public int orangesRotting(int[][] grid) {
        int ans=0;
        int n = grid.length;
        int m = grid[0].length;

        ans = bfs(grid);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }

    static class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    private int bfs(int[][] grid){
       
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                   q.add(new Pair(i,j));
                }
            }
        }
        
        int time=0;
        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,-1,0,1};

        while(!q.isEmpty()){
            int len=q.size();
            while(len-- > 0){
                int r = q.peek().row;
                int c = q.peek().col;
                q.poll();
                // if(grid[r][c] != 2) continue;
                
                for(int i=0;i<4;i++){
                    int newRow = r + delRow[i];
                    int newCol = c + delCol[i];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                        q.add(new Pair(newRow, newCol));
                        grid[newRow][newCol]=-2;
                    }
                }
            }

            if(q.size() > 0) time++;

        }
        return time;
    }
}