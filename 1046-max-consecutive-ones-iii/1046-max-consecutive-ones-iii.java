class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length,l=0,r=0,maxlen=0;
        int numZero=0,numOne=0;

        while(r<n){
            if(nums[r] == 0){
                numZero++;
            }else{
                numOne++;
            }
            while(l<= r && numZero > k){
                if(nums[l]==0){
                    numZero--;
                }

                if(nums[l]==1){
                    numOne--;
                }
                l++;
            }

            maxlen = Math.max(maxlen,(r-l+1));
            r++;
        }
        return maxlen;
    }
}