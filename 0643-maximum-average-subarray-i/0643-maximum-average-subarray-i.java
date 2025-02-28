class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0,right=0,sum=0,n=nums.length,maxsum=0;
        while(right<k){
            sum += nums[right++];
        }

        maxsum=sum;

        while(right<n){
            sum += nums[right++];
            sum -= nums[left++];
            maxsum = Math.max(maxsum,sum);
        }

        return 1.0*maxsum/k;
    }
}