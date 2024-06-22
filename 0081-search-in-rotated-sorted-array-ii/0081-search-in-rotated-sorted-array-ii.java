class Solution {
    public boolean search(int[] nums, int target) {
        int partitionIndex = -1;
        boolean ans=false;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] != nums[i] && nums[i-1]>nums[i]){
                partitionIndex = i;
                break;
            }
        }
    
        if(partitionIndex!= -1){
            if(nums[0] <= target && nums[partitionIndex-1] >= target){
                ans=bsearch(nums,0,partitionIndex-1,target);
            }else{
                ans=bsearch(nums,partitionIndex,nums.length-1,target);
            }
        }else{
            ans=bsearch(nums,0,nums.length-1,target);
        }
        return ans;
    }

    public boolean bsearch(int[] arr,int s,int e,int k){
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] == k){
                return true;
            }else if(arr[mid] > k){
                e = mid-1;
            }else{
                s=mid+1;
            }
        }
        return false;
    }
}