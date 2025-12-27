class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int target = sum/2;

        return isTargetPresent(nums,target);
    }

    private boolean isTargetPresent(int[] nums, int target){
        int n = nums.length;

        boolean[][] dp = new boolean[n][target+1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }

        for(int idx=1;idx<n;idx++){
            for(int tar = 1;tar <= target;tar++){
                boolean take= false;
                if(nums[idx] <= tar){
                    take = dp[idx-1][tar-nums[idx]];
                }

                boolean notTake = dp[idx-1][tar];

                dp[idx][tar] = take || notTake;
            }
        }
        return dp[n-1][target];
    }
}