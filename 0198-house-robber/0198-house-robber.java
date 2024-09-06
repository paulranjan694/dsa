class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int take = nums[i];
            if(i>1) take += dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];

    }

    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp,-1);
    //    return utils(nums,n-1, dp);
    // }

    // private int utils(int[] nums, int idx, int[] dp){
    //     if(idx == 0) return nums[idx];
    //     if(idx < 0) return 0;
    //     if(dp[idx] != -1)
    //         return dp[idx];

    //     int take = nums[idx] + utils(nums, idx-2,dp);
    //     int notTake = 0 + utils(nums, idx-1,dp);
    //     dp[idx] = Math.max(take, notTake);
    //     return dp[idx];
    // }
}