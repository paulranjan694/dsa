class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        int n = nums.length;
       int idx=0;
        for(int i=1;i<n;i++){
            if(i+1 < n && nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                result[idx++]=nums[i]; 
            }
        }
        if(n>1 && nums[0] != nums[1]){
            result[idx++] = nums[0];
        }
        if(n-2 >= 0 && nums[n-2] != nums[n-1]){
            result[idx++] = nums[n-1];
        }
        return result;
    }
}