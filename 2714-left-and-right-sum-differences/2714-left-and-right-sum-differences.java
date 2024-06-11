class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalSum=0,n=nums.length;

        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }

        int prefixSum=0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(prefixSum-(totalSum-prefixSum-nums[i]));
            prefixSum+=nums[i];
        }

        return ans;
    }
}