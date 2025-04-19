class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,n=nums.length,max=0,zeroCount=0;
        while(r<n){
            if(nums[r]==0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[l] == 0){
                    zeroCount--;
                }
                l++;
            }

            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}