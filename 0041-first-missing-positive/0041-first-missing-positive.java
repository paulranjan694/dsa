class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean isOnePresent = false;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                isOnePresent = true;
                break;
            }
        }
        if(!isOnePresent){
            return 1;
        }

        int idx=0;
        while(idx < n){
            int correctindex = nums[idx]-1;
            if(nums[idx] > 0 && nums[idx] <= n && nums[idx]!= nums[correctindex]){
                int t = nums[idx];
                nums[idx] = nums[correctindex];
                nums[correctindex] = t;
            }else{
                idx++;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return n+1;
    }
}