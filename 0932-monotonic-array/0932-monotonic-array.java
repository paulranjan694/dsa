class Solution {
    public boolean isMonotonic(int[] nums) {
        int count=0, n = nums.length;
        int idx=1;
        for(int j=1;j<n;j++){
            if(nums[j]!=nums[j-1]){
                nums[idx++] = nums[j];
            }
        }

        for(int i=0;i<idx-1;i++){
            if(i+1< n && i-1>=0 && ((nums[i] > nums[i+1] && nums[i]> nums[i-1]) || (nums[i] < nums[i+1] && nums[i] < nums[i-1]))){
                count++;
            }
        }

        if(count>0){
            return false;
        }
        return true;
        
    }
}