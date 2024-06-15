class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int e : nums)
            max=Math.max(max,e);

        int l=0,r=0,count=0,n=nums.length;
        long ans=0;
        while(r<n){
            if(nums[r]==max){
                count++;
            }
            while(count==k){
                if(nums[l]==max){
                    count--;
                }
                l++;
            }
            ans+=l;
            r++;
        }

        return ans;
    }
}