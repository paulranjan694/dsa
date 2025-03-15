class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips=0,n=nums.length,ans=0;
        for(int i=0;i<n;i++){
            if(i>=k){
                if(nums[i-k] > 1){
                    nums[i-k] -= 2;
                    flips--;
                }
            }
            if((nums[i]==1 && flips % 2 == 1) || (nums[i] == 0 && flips % 2 == 0)){
                if(i+k > n) return -1;
                flips++;
                ans++;
                nums[i] += 2;
            }
        }
        if(nums[n-k] > 1) {
            nums[n-k] -= 2;
        }
        return ans;
    }
}