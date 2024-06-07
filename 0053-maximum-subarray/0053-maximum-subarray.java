class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ans=Math.max(ans,sum);
            sum=Math.max(sum,0);
        }
        return ans;
    }
}