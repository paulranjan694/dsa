class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightmax = new int[n];
        rightmax[n-1] = nums[n-1];

        for(int i=n-2;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1],nums[i]);
        }

        int l=0,r=0,ans=0;
        while(r<n){
            while(l<r && nums[l] > rightmax[r]){
                l++;
            }
            ans = Math.max(ans,r-l);
            r++;
        }
        return ans;
    }
} 