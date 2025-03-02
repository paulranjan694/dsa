class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            if(grid[n-1][i] < 0){
                for(int j=n-1;j>=0;j--){
                    if(grid[j][i] < 0){
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }  
        return count; 
    }
}