class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m=nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int[] a: dp){
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        return utils(nums1,nums2, n,m,0,0, dp);
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