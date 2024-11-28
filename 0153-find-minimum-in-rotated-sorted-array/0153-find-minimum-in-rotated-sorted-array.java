class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int s =0,e=n-1,min = Integer.MAX_VALUE;

        while(s<=e){
            int mid = (s+e)/2;
            min=Math.min(min,nums[mid]);
            if(nums[mid] >= nums[s]){//left part sorted
                if(nums[s] < nums[e] && nums[mid] < nums[e]){
                    e = mid-1;
                }else{
                    s=mid+1;
                }
            }else{//right part sorted
                if(nums[e] > nums[s] && nums[e] > nums[mid]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
            
        }
        return min;
    }
}