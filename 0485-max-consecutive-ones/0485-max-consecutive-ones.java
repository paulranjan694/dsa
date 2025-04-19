class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r=0,n=nums.length,max=0;
        while(r<n){
            if(nums[r]!=1){
                max = Math.max(max,r-l);
                l=r+1;
            }
            r++;
        }
        max = Math.max(max,r-l);
        return max;
    }
}