class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalSum = 0, n=nums.length;
      

        for(int e:nums){
            totalSum += e;
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum/2;
        memo = new Boolean[n][target+1];

        return solve_tab(nums, target);
    }

    private boolean solve_tab(int[] nums, int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for(int tar=0;tar<=target;tar++){
            if(tar==0 || nums[0] == tar) dp[0][tar] = true;
        }

        for(int i=1;i<=n;i++){
            dp[i][0] = true;
        }

        for(int idx=1;idx<n;idx++){
            for(int tar = 1; tar<=target;tar++){
                boolean notPick = dp[idx-1][tar];

                boolean pick = false;
                if(nums[idx] <= tar){
                    pick = dp[idx-1][tar-nums[idx]];
                }
                dp[idx][tar] = pick || notPick;
            }
        }
        return dp[n-1][target];
    }

    private boolean solve(int[] nums, int target, int idx){
        if(idx==0){
            if(target == 0 || nums[0] == target) return true;
            return false;
        }

        if(memo[idx][target] != null) return memo[idx][target]; 

        boolean notPick = solve(nums, target, idx-1);

        boolean pick = false;
        if(nums[idx] <= target){
            pick = solve(nums, target-nums[idx], idx-1);
        }
        return memo[idx][target] = pick || notPick;
    }
}