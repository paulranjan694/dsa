class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       // int[][] visited = new int[n][m];
        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    // bfs(grid,visited,i,j,n,m);
                    dfs(grid,i,j,n,m);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int row, int col, int n, int m){
        //base cond
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col] != '1') return;

        grid[row][col]='0'; //mark visited with 0

        dfs(grid,row,col+1,n,m);
        dfs(grid,row,col-1,n,m);
        dfs(grid,row-1,col,n,m);
        dfs(grid,row+1,col,n,m);

    }

    // private void getDirection(int[][] dir){
    //     dir[0][0]=0;
    //     dir[0][1]=1;
    //     dir[1][0]=0;
    //     dir[1][1]=-1;
    //     dir[2][0]=-1;
    //     dir[2][1]=0;
    //     dir[3][0]=1;
    //     dir[3][1]=0;
    // }

    // private void bfs(char[][] grid, int[][] visited, int row, int col, int n, int m){
    //     visited[row][col] = 1;
    //     Queue<Pair> queue = new LinkedList<Pair>();
    //     queue.add(new Pair(row,col));

    //     int[][] dir = new int[4][2];
    //     getDirection(dir);

    //     while(!queue.isEmpty()){
    //         int trow = queue.peek().row;
    //         int tcol = queue.peek().col;
    //         queue.remove();

    //         for(int i=0;i<4;i++){
    //             int dr=dir[i][0];
    //             int dc=dir[i][1];

    //             int r = trow+dr;
    //             int c = tcol+dc;
    //             if(r>=0 && r<n && c>=0 && c<m && grid[r][c]== '1' && visited[r][c]==0){
    //                 queue.add(new Pair(r,c));
    //                 visited[r][c]=1;
    //             }
    //         }
    //     }
    // } 

}

// class Pair{
//         int row,col;
//         public Pair(int row,int col){
//             this.row=row;
//             this.col=col;
//         }
// }