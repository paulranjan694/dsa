class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //int[] dp = new int[n];
       // dp[0] = nums[0];

       int prev1 = nums[0],prev2=0,curr=0;

        for(int i=1;i<n;i++){
            int take = nums[i];
            if(i-2>=0) take += prev2;

            int nottake=0;
            if(i-1 >= 0) nottake = prev1;

            curr = Math.max(take,nottake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
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