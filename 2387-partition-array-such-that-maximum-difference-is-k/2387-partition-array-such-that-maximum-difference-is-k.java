class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int partitionCount = 0,left=0,right=1,n=nums.length;
        while(right<n){
            if(nums[right]-nums[left] > k){
                partitionCount++;
                left=right;
            }
            right++;
        }
        return partitionCount+1;
    }
}