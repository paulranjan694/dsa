class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;){
            if(nums[i] > 0){
                nums[i] = -nums[i];
                i = -1 * nums[i];
            }else{
                return i;
            }
        }
        return -1;
    }
}