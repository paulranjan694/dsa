class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,minlen=Integer.MAX_VALUE,sum=0,n=nums.length;
        while(right < n){
            sum += nums[right];
            if(sum >= target) minlen = Math.min(minlen,right-left+1);
            while(left<right && sum>target){
                sum -= nums[left];
                left++;
                if(sum >= target) minlen = Math.min(minlen,right-left+1);
            }
            right++;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen ;
    }
}