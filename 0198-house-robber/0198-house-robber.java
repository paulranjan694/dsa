class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int take=nums[i];
            if(i>1) take += dp[i-2];
            int nottake = dp[i-1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[n-1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        return utils(nums,n-1);
    }

    private int utils(int[] nums, int idx){
        if(idx<0) return 0;
        if(idx==0) return nums[idx];
        int take = nums[idx] + utils(nums,idx-2);
        int nottake = utils(nums,idx-1);
        return Math.max(take,nottake);
    }
}