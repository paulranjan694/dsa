/**
    check if arr[i-1] < ar[i] Pair exists == 1, return true else not sorted and rotated.
    check the last and first pair too...

 */
class Solution {
    public boolean check(int[] nums) {
        int n =nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i] > nums[(i+1) % n]){
                count++;
            }

            if(count > 1) return false;
        }
        return true;
    }
}