class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        for(int i=0;i<triangle.get(n-1).size();i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            for(int j = i;j >= 0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];

                int min = Math.min(down,diagonal);
                dp[i][j] = min;
            }
        }

        return dp[0][0];
    }

    public int minimumTotal_memoization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return utils(triangle, 0,0,dp);
    }

    private int utils(List<List<Integer>> triangle, int r, int c,int[][] dp){
        if(r == triangle.size()-1){
             dp[r][c] = triangle.get(r).get(c);
            return triangle.get(r).get(c);
        }

        if(dp[r][c] != -1) return dp[r][c];

        int down = triangle.get(r).get(c) + utils(triangle, r+1, c,dp);
        int diagonal = triangle.get(r).get(c) + utils(triangle, r+1, c+1,dp);

        int min = Math.min(down,diagonal);
        dp[r][c] = min;
        return dp[r][c];
    }
}