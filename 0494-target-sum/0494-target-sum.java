class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    private int solve(int[] nums, int target, int idx, int sum){
        if(idx == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }

        int positive = solve(nums, target, idx+1, sum+nums[idx]);
        int negative = solve(nums, target, idx+1, sum-nums[idx]);

        return positive + negative;
    }
}