class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int l = 1,r = nums.length - 2;

        if(nums[0] != nums[1]) return nums[0];
        if(nums[r] != nums[r+1]) return nums[r+1];

        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] == nums[m+1] || nums[m] == nums[m-1]){
                if(nums[m] == nums[m-1]){
                    if(m % 2 == 0){
                        r=m-1;
                    }else{
                        l=m+1;
                    }
                }else{
                    if(m % 2 == 0){
                        l=m+1;
                    }else{
                        r=m-1;
                    }
                }
            }else{
                return nums[m];
            }
        }
        return -1;
    }
}