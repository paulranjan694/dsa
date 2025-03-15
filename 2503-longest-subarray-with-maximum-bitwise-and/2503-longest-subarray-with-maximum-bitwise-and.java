class Solution {
    public int longestSubarray(int[] nums) {
        int ans=0,n=nums.length,maxelement=0,count=0;

        for(int num : nums){
            maxelement = Math.max(maxelement,num);
        }

        for(int i=0;i<n;i++){
            if(nums[i]==maxelement){
                count++;
            }else{
                count=0;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}