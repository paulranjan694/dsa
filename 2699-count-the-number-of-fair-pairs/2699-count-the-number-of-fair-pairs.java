class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int lowerCount = lowerBound(nums, i+1, lower - nums[i]);
            int upperCount = upperBound(nums, i+1, upper - nums[i]);
            count += upperCount-lowerCount+1;
        }
        return count;
    }

    private int lowerBound(int[] nums, int start, int target){
        int low = start,high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private int upperBound(int[] nums, int start, int target){
        int low = start,high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
}