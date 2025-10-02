class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum %2 != 0) return false;

        int target = sum / 2, n= nums.length;
        Boolean[][] dp = new Boolean[n][target+1];
        for(Boolean[] d : dp){
            Arrays.fill(d, null);
        }

        return isSubsetSum(nums, target, n-1, dp);
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