class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length,ans=0;
        for(int i=0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                int l = j,r=n-1;
                while(l<r){
                    if(nums[i] + nums[l] > nums[r]){
                        ans++;
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}