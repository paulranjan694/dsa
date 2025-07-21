class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        List<Integer>[][] dp = new ArrayList[n][n+1];
        
        return lis(nums,0,-1,dp);
    }

    private List<Integer> lis(int[] nums, int idx, int prev, List<Integer>[][] dp ){
        if(idx==nums.length) {
            return new ArrayList<>();
        }
        
        if (dp[idx][prev + 1] != null) {
            return dp[idx][prev + 1];
        }

        List<Integer> take = new ArrayList<>();
        if(prev == -1 || nums[idx] % nums[prev]==0){
           take = new ArrayList<>();
            take.add(nums[idx]);
            take.addAll(lis(nums, idx + 1, idx, dp));
        }


        List<Integer> skip = lis(nums, idx + 1, prev, dp);

        // Take the longer one
        if (take.size() > skip.size()) {
            dp[idx][prev + 1] = take;
        } else {
            dp[idx][prev + 1] = skip;
        }

        return dp[idx][prev + 1];
    } 
}