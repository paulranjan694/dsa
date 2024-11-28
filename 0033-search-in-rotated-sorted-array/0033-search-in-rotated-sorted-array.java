class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0]==target) return 0;
        if(nums.length == 1 && nums[0]!=target) return -1;

        int n =nums.length;
        int s=0,e=n-1;

        while(s<=e){
            int mid = (s+e)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= nums[s]){ //left part sorted
                if(target >= nums[s] && target < nums[mid]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }else{//right part sorted
                if(target > nums[mid] && target <= nums[e]){
                   s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }
}