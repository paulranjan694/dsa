class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;

        for(int num : nums){
            max=Math.max(num,max);
        }

        int maxCount=0,left=0,right=0,n=nums.length;
        long ans=0;
        while(right<n){
            if(nums[right]==max){
                maxCount++;
            }

            while(maxCount == k){
                ans += n-right;
                if(nums[left++]==max){
                    maxCount--;
                }
            }

            right++;
        }

        return ans;
    }
}