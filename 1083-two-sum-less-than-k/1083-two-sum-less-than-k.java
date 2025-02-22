class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int n =nums.length,ans=-1;
        for(int i=0;i<n;i++){
            int left = i+1,right=n-1;
            while(left<=right){
                int mid = left + (right - left)/2;
                if(nums[i] + nums[mid] < k){
                    ans = Math.max(ans,nums[i]+nums[mid]);
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }
        return ans;
    }
}