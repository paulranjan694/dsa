class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];

        for(int i=0;i<walls.length;i++){
            mat[walls[i][0]][walls[i][1]] = -2;
        }

        for(int i=0;i<guards.length;i++){
            mat[guards[i][0]][guards[i][1]]=-1;
        }

        for(int i=0;i<guards.length;i++){
            dfs(mat, guards[i][0],guards[i][1]-1,m,n,"u");
            dfs(mat, guards[i][0],guards[i][1]+1,m,n,"d");
            dfs(mat, guards[i][0]-1,guards[i][1],m,n,"l");
            dfs(mat, guards[i][0]+1,guards[i][1],m,n,"r");
        }

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(mat[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] mat, int x, int y, int m , int n, String dir){
        if(x<0 || x>=m || y<0 || y>=n || mat[x][y] == -2 || mat[x][y] == -1) return;
        mat[x][y]=1;
        if(dir == "u")  dfs(mat, x, y-1, m,n,"u");
        else if(dir == "d")  dfs(mat, x, y+1, m,n,"d");
        else if(dir == "l")  dfs(mat, x-1, y, m,n,"l");
        else if(dir == "r")  dfs(mat, x+1, y, m,n,"r");
    }
}