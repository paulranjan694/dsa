class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, totalSum = 0;

        for(int num : nums){
            totalSum+=num;
        }

        int tar = totalSum - target;
        if(tar < 0 || tar % 2 != 0) return 0;
        tar = tar/2;

        int[] dp = new int[tar+1];

        // Base case
        if (nums[0] == 0) {
            dp[0] = 2; // take or not take
        } else {
            dp[0] = 1;
            if (nums[0] <= tar) dp[nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[tar + 1];

            for (int sum = 0; sum <= tar; sum++) {
                int notTake = dp[sum];
                int take = (nums[i] <= sum) ? dp[sum - nums[i]] : 0;
                curr[sum] = (take + notTake);
            }
            dp = curr;
        }

        return dp[tar];
    }
}