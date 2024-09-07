class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
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
        return min;
    }
}