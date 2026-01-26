class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.sort(nums);

        Arrays.fill(dp,1);
        int lastIndex=0;
        for(int i=1;i<n;i++){
            hash[i] = i;

            for(int j=0;j<i;j++){
                if((nums[i]%nums[j] == 0) && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i]=j;
                }
            }

            if(dp[lastIndex] < dp[i]){
                lastIndex = i;
            }
        }
        res.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }

        Collections.reverse(res);
        return res;
    }
}