class Solution {
    public int minOperations(int[] nums) {
        int minflips=0,r=0,n=nums.length,k=3;
        while(r < n){
            if(nums[r] == 0){
                if(r+k-1>=n){
                    return -1;
                }
                int l=r,maxlen=r+k-1;
                while(maxlen < n && l <= maxlen){
                    nums[l] = nums[l]^1;
                    l++;
                }
                minflips++;
            }
            r++;
        }

        return minflips;
    }
}