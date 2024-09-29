class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return utils(nums, 0,-1,dp);
    }

    private int utils(int[] nums, int idx, int prevIdx, int[][] dp){
        //base case
        if(idx >= nums.length) return 0;
        if(dp[idx][prevIdx+1] != -1) return dp[idx][prevIdx+1];
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[idx])
            take = 1 + utils(nums, idx+1, idx,dp);
        int notTake = utils(nums,idx+1,prevIdx,dp);
        return dp[idx][prevIdx+1] =  Math.max(take,notTake);
    }
}