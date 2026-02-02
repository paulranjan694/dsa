class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum =0;
        for(int num : nums){
            totalSum += num;
        }

        int minSubArrSum = minSubArr(nums);
        int maxSubArrSum = maxSubArr(nums);

        int circularSum = totalSum - minSubArrSum;
        if(maxSubArrSum > 0){
            return Math.max(circularSum,maxSubArrSum);
        }
        return maxSubArrSum;
    }

    private int maxSubArr(int[] nums){
        int max = nums[0], sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max(sum+nums[i], nums[i]);
            max = Math.max(sum,max);
        }
        return max;
    }

    private int minSubArr(int[] nums){
        int min = nums[0], sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.min(sum+nums[i], nums[i]);
            min = Math.min(sum,min);
        }
        return min;
    }
}