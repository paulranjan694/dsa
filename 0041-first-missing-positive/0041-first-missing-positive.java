class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean oneExists = false;
        for(int i=0;i<n;i++){
            if(nums[i]>n || nums[i]<=0){
                nums[i]=n+1;
            }
        }

        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]);
            if(idx<=n){
                if(nums[idx-1] > 0){
                    nums[idx-1] = -1 * nums[idx-1];
                }
            }
        }

        for(int i = 0;i<n;i++){
            if(nums[i]>=0){
                return i+1;
            }
        }
        return n+1;
    }
}