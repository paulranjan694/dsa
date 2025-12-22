class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return utils(nums, n-1,dp);
    }

    private int utils(int[] nums, int idx, int[] dp){
        if(idx==0) return nums[0];
        if(dp[idx] != -1) return dp[idx];
        int take = nums[idx];
        if(idx-2 >= 0) take += utils(nums,idx-2,dp);

        int nottake = 0;
        if(idx-1 >= 0) nottake = utils(nums, idx-1,dp);

        return dp[idx]=Math.max(take,nottake);
    }
}