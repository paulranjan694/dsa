class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSubArr = nums[0], maxSubArr=nums[0],  maxSum=nums[0], minSum=nums[0], totalSum = nums[0];
        for(int i=1;i<nums.length;i++){
            maxSum = Math.max(maxSum+nums[i], nums[i]);
            maxSubArr = Math.max(maxSum,maxSubArr);

            minSum = Math.min(minSum+nums[i], nums[i]);
            minSubArr = Math.min(minSum,minSubArr);

            totalSum += nums[i];

        }

        int circularSum = totalSum - minSubArr;
        if(maxSubArr > 0){
            return Math.max(circularSum,maxSubArr);
        }
        return maxSubArr;
    }
}