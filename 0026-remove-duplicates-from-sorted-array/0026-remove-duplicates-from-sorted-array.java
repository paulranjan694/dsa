class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=1, n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1] != nums[i]){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}