class Solution {
    public int climbStairs(int n) {
        if(n==0) return 1;
        if(n < 0) return 0;

        int[] dp = new int[n+1];
        dp[n]=1;
        for(int i = n-1;i>=0;i--){
            dp[i] = 0;
            if(i+1 <= n){
                dp[i] += dp[i+1];
            }

            if(i+2 <= n){
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
        //return climbStairs(n-1) + climbStairs(n-2);
    }
}