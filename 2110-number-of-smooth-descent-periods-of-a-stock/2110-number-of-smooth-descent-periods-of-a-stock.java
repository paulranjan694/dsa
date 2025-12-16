class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long ans = (long)n;
        long[] dp = new long[n];
        for(int i=1;i<n;i++){
            int t=0;
            if(prices[i]-prices[i-1] == -1){
                t=1;
            }
            if(t>0)
                dp[i] = dp[i-1]+t;
        }
        for(long e : dp){
            ans += e;
        }
        return ans;
    }
}