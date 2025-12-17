import java.util.Arrays;

class Solution {
    static final long NEG_INF = -(long)1e18;
    long[][][] dp;

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new long[n][k + 1][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE);
            }
        }

        return utils(prices, k, 0, 0);
    }

    private long utils(int[] prices, int k, int idx, int state) {
        if (idx == prices.length) {
            return state == 0 ? 0 : NEG_INF;
        }
        if (k == 0) {
            return state == 0 ? 0 : NEG_INF;
        }

        if (dp[idx][k][state] != Long.MIN_VALUE) {
            return dp[idx][k][state];
        }

        long skip = utils(prices, k, idx + 1, state);
        long buy = NEG_INF, sell = NEG_INF;

        if (state == 0) {
            buy  = -prices[idx] + utils(prices, k, idx + 1, 1);
            sell =  prices[idx] + utils(prices, k, idx + 1, 2);
        } else if (state == 1) {
            sell = prices[idx] + utils(prices, k - 1, idx + 1, 0);
        } else { // state == 2
            buy = -prices[idx] + utils(prices, k - 1, idx + 1, 0);
        }

        return dp[idx][k][state] = Math.max(skip, Math.max(buy, sell));
    }
}
