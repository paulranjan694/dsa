class Solution {
    public int countSubarrays(int[] nums) {
        int ans=0,l=0,r=2,n=nums.length;

        while(r<n){
            double sum = nums[r]+nums[r-2];
            if(sum == (double)nums[r-1]/2){
                ans++;
            }
            r++;l++;
        }
        return ans;
    }
}