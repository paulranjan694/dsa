class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums[0] > nums[1]) return false;

        int i=0, n =nums.length;

        while(i+1<n && nums[i] < nums[i+1]){
            i++;
        }

        if(i==0 || i == n-1) return false;

        while(i+1 < n && nums[i] > nums[i+1]){
            i++;
        }

        if(i==0 || i == n-1) return false;

        while(i+1 < n && nums[i] < nums[i+1]){
            i++;
        }

        if(i==0 || i != n-1) return false;

        return true;



    }
}