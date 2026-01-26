class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        
        for(int idx = n-1; idx>=0;idx--){
            for(int prevIdx = idx-1;prevIdx>=-1;prevIdx--){
                int len = dp[idx+1][prevIdx+1];
                if(prevIdx == -1 || nums[idx]>nums[prevIdx]){
                    len = Math.max(len, 1 + dp[idx+1][idx+1]);
                }
                dp[idx][prevIdx+1]=len;
            }
        }
        return dp[0][0];
    }

    private int solve(int[] nums, int idx, int prevIdx){
        if(idx==nums.length) return 0;

        int len = solve(nums, idx+1, prevIdx);
        if(prevIdx == -1 || nums[idx]>nums[prevIdx]){
            len = Math.max(len, 1 + solve(nums,idx+1, idx));
        }
        return len;
    }
}