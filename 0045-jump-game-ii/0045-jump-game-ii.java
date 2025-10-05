class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;

        for(int i = n-2;i>=0;i--){
            int limit = Math.min(n-1, i+nums[i]);
            dp[i] = 1_000_000_000;
            for(int j = i+1;j<=limit;j++){
                dp[i] = Math.min(dp[i], 1+dp[j]);
            }
        }
        return dp[0];
    }
}