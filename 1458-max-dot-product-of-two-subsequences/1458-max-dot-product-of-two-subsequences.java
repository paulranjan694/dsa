class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m=nums2.length;
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            dp[i][m] = -1_000_000_00;
        }

        for(int i=0;i<=m;i++){
            dp[n][i] = -1_000_000_00;
        }

        for(int i = n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int max = nums1[i] * nums2[j];
                int takeBoth =  dp[i+1][j+1];
                int take_i_j = (nums1[i] * nums2[j]);
                if(takeBoth != -1_000_000_00){
                    take_i_j += takeBoth;
                }
                int take_i = dp[i][j+1];
                int take_j = dp[i+1][j];
                dp[i][j]=Math.max(Math.max(max, take_i_j), Math.max(take_i, take_j));
            }
        }

        return dp[0][0];
    }

    private int utils(int[] nums1, int[] nums2, int n, int m, int i, int j, int[][] dp){
        if(i==n || j==m) return -1_000_000_00;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int max = nums1[i] * nums2[j];
        int takeBoth = utils(nums1,nums2,n,m,i+1,j+1, dp);
        int take_i_j = (nums1[i] * nums2[j]);
        if(takeBoth != Integer.MIN_VALUE){
            take_i_j += takeBoth;
        }
        int take_i = utils(nums1,nums2,n,m,i,j+1, dp);
        int take_j = utils(nums1,nums2,n,m,i+1,j, dp);

        return dp[i][j]=Math.max(Math.max(max, take_i_j), Math.max(take_i, take_j));
    }
}