class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int idx = 0,val=0;
        
        while(idx < n){
            val = nums[idx]-1;
            if(val<n && val >= 0 && nums[val] != nums[idx]){
            int t = nums[idx];
            nums[idx] = nums[val];
            nums[val] = t;
            }else{
            idx++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(i+1 != nums[i]){
            return i+1;
            }
        }
        return n+1;
    }
}