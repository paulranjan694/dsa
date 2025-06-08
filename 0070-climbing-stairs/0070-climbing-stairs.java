class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return utils(n,dp);
    }

    private int utils(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] = utils(n-1,dp) + utils(n-2,dp);
    }
}