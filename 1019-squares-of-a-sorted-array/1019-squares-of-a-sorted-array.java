class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int idx=res.length-1;
        for(int i=0,j=nums.length-1;i<=j;){
            int left = nums[i]*nums[i];
            int right = nums[j]*nums[j];
            if(left>right){
                res[idx--]=left;
                i++;
            }else{
               res[idx--]=right;
                j--;
            }
        }
        return res;
    }
}