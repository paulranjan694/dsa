class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i=0;i<n;i++){
            if(i!=n-1){
                temp1[i]=nums[i];
            }

            if(i!=0){
                temp2[i]=nums[i];
            }
        }
        return Math.max(helper(temp1), helper(temp2));
    }

    private int helper(int[] nums){
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
}