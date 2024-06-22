class Solution {
    public int findMin(int[] nums) {
        int s=0,e=nums.length-1,ans=Integer.MAX_VALUE;
        int mid = (s+e)/2;
        
        ans =bsearch(nums,s,e);
        return ans;
    }

    public int bsearch(int[] nums, int s, int e){
        int ans=Integer.MAX_VALUE;
        while(s<=e){
            int mid = (s+e)/2;
            ans=Math.min(nums[mid],ans);
            if(mid+1 < nums.length && nums[mid] > nums[e]){
                s=mid+1;
            }else if(mid-1 >= 0 && nums[mid] > nums[mid-1]){
                e=mid-1;
            }else{
                return ans;
            }
        }
        return ans;
    }
}