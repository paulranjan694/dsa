class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0,n=nums.length;

        for(int num : nums){
            totalSum += num;
        }

        int t = (target+totalSum);
        if(t % 2 != 0 || totalSum < target || t < 0) return 0;
        t /= 2;

        int[][] dp = new int[n+1][t+1];

        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=0;j<=t;j++){
                if(nums[i-1] <=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][t];
    }
}