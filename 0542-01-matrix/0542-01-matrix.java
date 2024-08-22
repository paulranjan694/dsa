class Solution {
    public int[][] updateMatrix(int[][] mat) {
        return bfs(mat);
    }

    public int[][] bfs(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
       // int minVal = Integer.MAX_VALUE;

        int[] rowDif = {0,1,0,-1};
        int[] colDif = {1,0,-1,0};

        int[][] ans = new int[n][m];
      
        Queue<Pair> q = new LinkedList<>();

        int[][] visited=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                     visited[i][j] = 1;
                }
            }
        }

     

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            q.poll();

            ans[row][col] = dist;

            for(int i=0;i<4;i++){
                int tempRow = row + rowDif[i];
                int tempCol = col + colDif[i];

                if(tempRow >= 0 && tempRow < n && tempCol >= 0 && tempCol < m && visited[tempRow][tempCol] == 0){
                    visited[tempRow][tempCol] = 1;
                    q.add(new Pair(tempRow,tempCol,dist+1));
                }
            }
        }

        return ans;
    }

    static class Pair{
        int row,col,dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}