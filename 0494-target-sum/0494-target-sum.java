class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // int[][] dp = new int[n][target+1];

        // for()
        return solve(nums, target, n-1, 0);
    }

    private int solve(int[] nums, int target, int idx, int sum){
        if(idx == 0){
            int cnt = 0;
            if(sum+nums[idx] == target){
                cnt++;
            }

            if(sum-nums[idx] == target){
                cnt++;
            }

            return cnt;
        }

        int positive = solve(nums, target, idx-1, sum+nums[idx]);
        int negative = solve(nums, target, idx-1, sum-nums[idx]);

        return positive + negative;
    }
}