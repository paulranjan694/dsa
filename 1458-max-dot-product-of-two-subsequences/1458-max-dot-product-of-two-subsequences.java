class Solution {
    private final int NEG = Integer.MIN_VALUE/2;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m=nums2.length;
        if(m>n){
            return maxDotProduct(nums2, nums1);
        }
        int[] dp = new int[m+1];
        
        for(int i=0;i<=m;i++){
            dp[i] = NEG;
        }

        for(int i = n-1;i>=0;i--){
            int[] curr = new int[m+1];
            curr[m] = NEG;
            for(int j=m-1;j>=0;j--){
                int max = nums1[i] * nums2[j]; 
                int take_i_j = max + dp[j+1];
                int take_i = curr[j+1];
                int take_j = dp[j];
                curr[j]=Math.max(Math.max(max, take_i_j), Math.max(take_i, take_j));
            }
            dp = curr;
        }

        return dp[0];
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