class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length,ans=-1;

        for(int i=0;i<n;){
            if(nums[i] > 0){
                nums[i] = -nums[i];
                i = -1 * nums[i];
            }else{
                ans=i;
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            nums[i] = -1 * nums[i];
        }
        return ans;
    }
}