class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] answer = new int[m];

        for(int i=0;i<m;i++){
            boolean possible = true;
            int col=i;
            for(int row=0;row<n;row++){
                if((col < 0 || col > m) || (row==0 && (col==0 && grid[row][col]==-1) || (col==m-1 && grid[row][col]==1))){
                    possible = false;
                    break;
                }
                
                if(grid[row][col] == 1){
                    if(col+1 < m && grid[row][col+1] == -1){
                        possible=false;
                        break;
                    }
                    col++;
                }else{
                    if(col-1 >= 0 && grid[row][col-1] == 1){
                        possible=false;
                        break;
                    }
                    col--;
                }
            }
            if(possible==true){
                answer[i]=col;
            }else{
                answer[i]=-1;
            }
        }
        return answer;
    }
}