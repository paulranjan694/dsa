class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0,n=nums.length;
        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0){
            return false;
        }

        int target = sum/2;

        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0;i<target+1;i++){
            if(i==0){
                dp[0][i]=true;
            }else{
                dp[0][i] = false;
            }
        }

        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][target];
    }
}