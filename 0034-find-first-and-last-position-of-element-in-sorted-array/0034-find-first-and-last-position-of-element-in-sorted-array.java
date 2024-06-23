class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0,e = nums.length-1;
        int firstOcr = bsearchFirstOcr(nums,target,s,e);
        int secondOcr = bsearchSecondOcr(nums,target,s,e);

        int[] res = new int[2];
        res[0] = firstOcr;
        res[1] = secondOcr;

        return res;
    }

    public int bsearchFirstOcr(int[] nums, int target, int s, int e){
        int ans=-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]==target){
                ans=mid;
                e=mid-1;
            }else if(nums[s]<=target && target <= nums[mid]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }

    public int bsearchSecondOcr(int[] nums, int target, int s, int e){
        int ans=-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]==target){
                ans=mid;
                s=mid+1;
            }else if(nums[s]<=target && target <= nums[mid]){
                e=mid-1;
            }else{
                 s=mid+1;
            }
        }
        return ans;
    }

}