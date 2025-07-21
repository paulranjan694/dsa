class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return lis(nums,0,-1,dp);
    }

    private int lis(int[] nums, int idx, int prev, int[][] dp){
        //base condition
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }

        int take = 0;
        if(prev == -1 || nums[prev] < nums[idx]){
            take = 1 + lis(nums, idx+1, idx, dp);
        }
        int notTake = lis(nums, idx+1, prev, dp);

        return dp[idx][prev+1]=Math.max(take,notTake);
    }
}