class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preprd=new int[n];
        preprd[0] = 1;
        for(int i = 1 ; i < n;i++){
            preprd[i] = preprd[i-1] * nums[i-1];
        }

        int prd = 1;
        for(int i = n-2; i>=0; i--){
            preprd[i] = preprd[i] * prd * nums[i+1];
            prd *= nums[i+1];
        }
        return preprd;
    }
}