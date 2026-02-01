class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        if(n<=3){
            int total = 0;
            for(int e : nums){
                total += e;
            }
            return total;
        }

        int min=Integer.MAX_VALUE, secMin=Integer.MAX_VALUE;

        for(int i=1;i<n;i++){
            if(min>nums[i]){
                secMin = min;
                min = nums[i];
            }else if(secMin > nums[i]){
                secMin = nums[i];
            }
        }

        return nums[0] + min + secMin;
    }
}