class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int s=0,e=n-1, min = Integer.MAX_VALUE;

        while(s<=e){
            int mid = (s+e)/2;
            if(nums[s]==nums[mid] && nums[mid]==nums[e]){
                min=Math.min(min,nums[mid]);
                s++;e--;
                continue;
            }
            if(nums[s] <= nums[mid]){
                min=Math.min(min,nums[s]);
                s=mid+1;
            }else{
                min=Math.min(min,nums[mid]);
                e=mid-1;
            }
        }
       
        return min;
    }
}