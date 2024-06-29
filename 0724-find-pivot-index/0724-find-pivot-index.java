class Solution {
    public int pivotIndex(int[] nums) {
        int tsum=0;
        for(int e:nums){
            tsum+=e;
        }

        int psum=0;
        for(int i=0;i<nums.length;i++){
            if(psum == (tsum-psum-nums[i])){
                return i;
            }
            psum+=nums[i];
        }

        return -1;
    }
}