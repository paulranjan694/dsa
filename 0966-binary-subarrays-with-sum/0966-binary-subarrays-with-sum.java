class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return (numberSubArr(nums,goal) - numberSubArr(nums, goal-1));
    }

    public int numberSubArr(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length, l = 0, r=0, sum=0,count=0;

        while(r<n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            if(sum <= goal){
                count += (r-l+1);
            }
            r++;
        }
        return count;
    }
}