class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;

        int l = 1,r=n-2;

        while(l <= r){
            int mid = (l+r)/2;

            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }else{
                if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return 0;

      
    }
}