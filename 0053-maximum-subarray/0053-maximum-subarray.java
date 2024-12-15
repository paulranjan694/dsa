class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max=Integer.MIN_VALUE,n=nums.length,sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            max=Math.max(max,sum);
            sum=Math.max(sum,0);
        }
        return max;
    }
}