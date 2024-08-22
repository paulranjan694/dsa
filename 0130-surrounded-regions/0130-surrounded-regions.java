class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];
        //1 row
        for(int i=0;i<m;i++){
           if(visited[0][i] == 0 && board[0][i]=='O'){
                dfs(board,visited,0,i,n,m, false);
            }else{
                visited[0][i]=1;
            }
        }

        //last row

        for(int i=0;i<m;i++){
           if(visited[n-1][i] == 0 && board[n-1][i]=='O'){
                dfs(board,visited,n-1,i,n,m, false);
            }else{
                visited[n-1][i]=1;
            }
        }

        //1 col
        for(int i=0;i<n;i++){
           if(visited[i][0] == 0 && board[i][0]=='O'){
                dfs(board,visited,i,0,n,m, false);
            }else{
                visited[i][0]=1;
            }
        }

        //last col
        for(int i=0;i<n;i++){
           if(visited[i][m-1] == 0 && board[i][m-1]=='O'){
                dfs(board,visited,i,m-1,n,m, false);
            }else{
                visited[i][m-1]=1;
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0 && board[i][j]=='O'){
                    dfs(board,visited,i,j,n,m,true);
                }else{
                    visited[i][j]=1;
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] visited, int r, int c, int n, int m, boolean mark){

        //base cond
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c] == 1 || board[r][c] == 'X' ) return;

        int[] rowDif = {0,1,0,-1};
        int[] colDif = {1,0,-1,0};

        visited[r][c] = 1;
        if(mark) board[r][c]='X';
   
        for(int i=0;i<4;i++){
            int newRow = r + rowDif[i];
            int newCol = c + colDif[i];
            dfs(board,visited,newRow,newCol,n,m,mark);
        }
    }
}