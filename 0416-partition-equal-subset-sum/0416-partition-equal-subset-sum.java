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

        return solve(nums, target,n-1);
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