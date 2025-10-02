class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum %2 != 0) return false;

        int target = sum / 2, n= nums.length;
        Boolean[][] dp = new Boolean[n][target+1];

        
        // for(Boolean[] d : dp){
        //     Arrays.fill(d, null);
        // }

        
        for(int s=1;s<=target;s++){
            if(s-nums[0] == 0) dp[0][s] = true;
            else dp[0][s] = false; 
        }

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<n;i++){
            for(int s=1;s<=target;s++){
                boolean taken = false;
                if(s-nums[i] >= 0){
                    taken = dp[i-1][s-nums[i]];
                }

                boolean notTaken = dp[i-1][s];

                dp[i][s] = taken || notTaken;
            }
        }

        return dp[n-1][target];
    }

    private Boolean isSubsetSum(int arr[], int sum, int idx, Boolean[][] dp) {
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(idx==0){
            if(sum - arr[0] == 0) return true;
            return false;
        }

        if(dp[idx][sum] != null) return dp[idx][sum];
        
        boolean taken = isSubsetSum(arr, sum-arr[idx], idx-1, dp);
        if(taken == true) return true;
        boolean notTaken = isSubsetSum(arr, sum, idx-1, dp);
        return dp[idx][sum]= taken || notTaken;
    } 
}