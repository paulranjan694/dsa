class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex=0, n=nums.length;
        for(int i=0;i<n;i++){
            if(maxIndex < i){
                return false;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}