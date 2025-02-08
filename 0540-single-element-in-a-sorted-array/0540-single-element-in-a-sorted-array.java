class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l =0,h=n-1;
        while(l<=h){
            int mid = l + (h-l) /2;
            if(mid-1 >= 0 && mid+1 < n &&( nums[mid-1] == nums[mid] || nums[mid+1] == nums[mid])){
            if(nums[mid-1] == nums[mid]){
                if(mid % 2 != 0){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }else{
                if((mid) % 2 != 0){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
            }else{
                return nums[mid];
            }
        }
        return -1;
    }
}