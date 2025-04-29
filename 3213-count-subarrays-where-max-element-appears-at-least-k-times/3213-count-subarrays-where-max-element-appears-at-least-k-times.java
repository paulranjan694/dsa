class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1,n=nums.length;

        for(int i=0; i< n;i++){
            max=Math.max(nums[i],max);
        }

        int maxCount=0,left=0,right=0;
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