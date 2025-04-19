class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, l=0,r=0,zeroCount=0,max=0;

        while(r<n){
            if(nums[r] == 0){
                zeroCount++;
            }

            while(zeroCount > 1){
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