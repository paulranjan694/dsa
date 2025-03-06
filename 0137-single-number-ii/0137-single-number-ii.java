class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1) return nums[0];
        if(n>1 && nums[0] != nums[1]){
            return nums[0];
        }

        if(n-2 >= 0 && nums[n-2] != nums[n-1]){
            return nums[n-1];
        }

        for(int i=1;i<n;i=i+3){
            if(nums[i]!= nums[i-1]){
                return nums[i-1];
            }
        }
        return -1;
    }
}