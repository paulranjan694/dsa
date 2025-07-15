class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length,maxSum=Integer.MIN_VALUE,sum=0;
        for(int num : nums){
            sum+=num;
            maxSum = Math.max(maxSum,sum);
            sum = Math.max(sum,0);
        }

        return maxSum;
    }
}