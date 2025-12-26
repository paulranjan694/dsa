class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];

        // Base case
        for (int c = 0; c < m; c++) {
            dp[n - 1][c] = mat[n - 1][c];
        }

        for (int r = n - 2; r >= 0; r--) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int minIdx = -1;

            // Find smallest & second smallest in next row
            for (int c = 0; c < m; c++) {
                if (dp[r + 1][c] < min1) {
                    min2 = min1;
                    min1 = dp[r + 1][c];
                    minIdx = c;
                } else if (dp[r + 1][c] < min2) {
                    min2 = dp[r + 1][c];
                }
            }

            // Fill current row
            for (int c = 0; c < m; c++) {
                dp[r][c] = mat[r][c] + (c == minIdx ? min2 : min1);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < m; c++) {
            ans = Math.min(ans, dp[0][c]);
        }
        return ans;
    }
}