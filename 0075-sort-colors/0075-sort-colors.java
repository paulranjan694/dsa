class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low=0,mid=0,high = n-1;

        while(mid<=high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;mid++;
            }else if(nums[mid] == 2){
                swap(nums,mid, high);
                high--;
            }else{
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}