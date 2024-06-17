class Solution {
    public int numSubseq(int[] nums, int target) {
        int l=0,r=nums.length-1,n=nums.length;
        int ans=0;
        int mod=1000000007;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0]=1;
        for(int i=1;i<n;i++){
            power[i] = (power[i-1] * 2) % mod;
        }

        while(l<=r){
            if(nums[l]+nums[r]<=target){
                ans+=power[r-l];
                ans=ans%mod;
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}