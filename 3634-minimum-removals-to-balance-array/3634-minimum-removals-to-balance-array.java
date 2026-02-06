class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length, i=0,j=0, len = 0;
        Arrays.sort(nums);
        while(i<n){
            while(j<n && (long)nums[j] <= (long)k * nums[i]){
                j++;
            }
            len = Math.max(len,j-i);
            i++;
        }
        return n-len;
    }
}