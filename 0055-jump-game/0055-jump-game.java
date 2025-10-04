class Solution {
    public boolean canJump(int[] nums) {
        //return utils(nums, 0);

        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        for(int i=n-2;i>=0;i--){
            if(nums[i] == 0) continue;
            int limit = Math.min(n-1, nums[i]);
            for(int j=1;j<=limit;j++){
                dp[i] = dp[i] || dp[i+j];
            }
        }
        return dp[0];
    }

    private boolean utils(int[] nums, int idx){
        if(idx == nums.length-1){
            return true;
        }
        if(idx >= nums.length){
            return false;
        }
        boolean result = false;
        for(int i=1;i<=nums[idx];i++){
            result = result || utils(nums, idx+i);
            if(result == true){
                return true;
            }
        }
        return result;
    }
}

/**

 */