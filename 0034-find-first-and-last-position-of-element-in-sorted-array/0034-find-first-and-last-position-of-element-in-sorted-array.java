class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        int firstOccr = bsearch_firstOccur(nums,0,n-1,target);
        int secOccr = bsearch_secOccur(nums,0,n-1,target);

        return new int[]{firstOccr,secOccr};
    }

    public int bsearch_firstOccur(int[] nums, int s, int e, int target){
        int idx=-1;
        while(s<=e){
            int mid= (s+e)/2;
            if(nums[mid] == target){
                idx=mid;
                e=mid-1;
            }else if(nums[mid] > target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return idx;
    }

    public int bsearch_secOccur(int[] nums, int s, int e, int target){
        int idx=-1;
        while(s<=e){
            int mid= (s+e)/2;
            if(nums[mid] == target){
                idx=mid;
                s=mid+1;
            }else if(nums[mid] > target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return idx;
    }
}