class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];

        // dp[0] = dp[1] = 1;

        int prev1=1,prev2=1,curr=0;

        for(int i=1;i<=n;i++){
            // dp[i] = dp[i-1];
            // if(i>1) dp[i] += dp[i-2];
            curr = prev1;
            if(i>1) curr += prev2;

            prev2=prev1;
            prev1=curr;
        }

        // return dp[n];
        return curr;
    }
}