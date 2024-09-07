class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        Arrays.fill(dp,0);

        for(int i=0;i<n;i++){
            int[] temp = new int[m];
             Arrays.fill(temp,0);
            for(int j=0;j<m;j++){
                if(i==0 && j==0) temp[j]=grid[i][j];
                else{
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if(i> 0) up = dp[j] + grid[i][j];
                    if(j > 0) left = temp[j-1] + grid[i][j];
                    temp[j] = Math.min(up,left);
                }
            }
            dp = temp;
        }
        return dp[m-1];
    }
}