class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int low=1,high=max,ans=-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isPossible(nums,threshold,mid)){
                ans=mid;
                high= mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int threshold, int div){
        int sum=0;
        for(int i = 0; i< nums.length;i++){
            sum+= Math.ceil((double)nums[i]/div);
        }
        return sum <= threshold;
    }
}