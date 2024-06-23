class Solution {
    public int findMin(int[] nums) {
        int s=0,e=nums.length-1,ans=Integer.MAX_VALUE;
         while(s<=e){
            int mid = (s+e)/2;
            if(nums[s]<=nums[mid]){
                ans=Math.min(nums[s],ans);
                s=mid+1;
            }else{
                ans=Math.min(nums[mid],ans);
                e=mid-1;
            }
        }
        return ans;
    }
}