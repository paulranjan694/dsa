class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length,ans=0;
        for(int i=n-1;i>=2;i--){
            int l = 0,r=i-1;
            while(l<r){
                if(nums[i] < nums[l] + nums[r]){
                   ans+=r-l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}