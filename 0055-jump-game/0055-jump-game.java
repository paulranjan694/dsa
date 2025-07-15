class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i=n-2;i>=0;i--){
            int end = Math.min(n-1,i+nums[i]);
            for(int j = i+1;j<=end;j++){
                if(dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    private boolean dfs(int[] nums, int idx,int[] dp){
        if(idx==nums.length-1) return true;
        if(dp[idx] != -1) return dp[idx] == 1;
        int end = Math.min(nums.length-1,idx+nums[idx]);
        for(int i = idx+1;i<=end;i++){
            if(dp[i] != -1) return dp[idx] == 1;
            boolean found = dfs(nums,i,dp);
            if(found==true) dp[i] = 1;
            else dp[i]=0;
            if(found==true){
                return true;
            }
        }
        return false;
    }
}