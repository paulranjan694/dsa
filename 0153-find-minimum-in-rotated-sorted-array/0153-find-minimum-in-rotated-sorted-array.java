class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;

        int s =0,e=n-1,min = Integer.MAX_VALUE;

        while(s<=e){
            int mid = (s+e)/2;
            //min=Math.min(min,nums[mid]);
            if(nums[mid] >= nums[s]){//left part sorted, so eliminate
                min=Math.min(min,nums[s]);
                s=mid+1;
            }else{//right part sorted, so eliminate right part
                min=Math.min(min,nums[mid]);
                e=mid-1;
            }
            
        }
        return min;
    }
}