class Solution {
    static final long NEG_INF = -(long)1e18;

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n + 1][k + 1][3];

        // Base case: after last day
        for (int t = 0; t <= k; t++) {
            dp[n][t][0] = 0;
            dp[n][t][1] = dp[n][t][2] = NEG_INF;
        }

        // Base case: zero transactions
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = dp[i][0][2] = NEG_INF;
        }

        // Fill DP table
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 1; t <= k; t++) {

                // State 0: no position
                dp[i][t][0] = Math.max(
                        dp[i + 1][t][0],
                        Math.max(
                                -prices[i] + dp[i + 1][t][1],
                                 prices[i] + dp[i + 1][t][2]
                        )
                );

                // State 1: holding long
                dp[i][t][1] = Math.max(
                        dp[i + 1][t][1],
                        prices[i] + dp[i + 1][t - 1][0]
                );

                // State 2: holding short
                dp[i][t][2] = Math.max(
                        dp[i + 1][t][2],
                        -prices[i] + dp[i + 1][t - 1][0]
                );
            }
        }

        return dp[0][k][0];
    }
}
