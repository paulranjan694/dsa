class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length,l=0,r=0,maxlen=0;
        int numZero=0;

        while(r<n){
            if(nums[r] == 0){
                numZero++;
            }
            if(numZero > k){
                if(nums[l]==0){
                    numZero--;
                }
                l++;
            }
            if(numZero<=k)
                maxlen = Math.max(maxlen,(r-l+1));
            r++;
        }
        return maxlen;
    }
}